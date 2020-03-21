import {Component, OnInit} from '@angular/core';
import {TournamentControllerImplService} from '../../api/services/tournament-controller-impl.service';
import {Tournament} from '../../api/models/tournament';
import {TournamentDay} from '../../api/models/tournament-day';
import {Ticket} from '../../api/models/ticket';

@Component({
    selector: 'app-tournament-overview',
    templateUrl: './tournament-overview.component.html',
    styleUrls: ['./tournament-overview.component.css']
})


export class TournamentOverviewComponent implements OnInit {

    tournaments: Array<Tournament> = [];
    messages = [];

    constructor(private ts: TournamentControllerImplService) {
    }

    ngOnInit(): void {
        this.loadTournaments();
    }

    loadTournaments() {
        this.ts.getTournamentsUsingGETResponse().subscribe({
            next: (response) => {
                this.analyzeResponseStatus(response.status);
                this.tournaments = this.tournaments.concat(response.body);
            },
            error: (error) => {
                this.analyzeResponseStatus(error.status);
            }
        });
    }

    analyzeResponseStatus(status: number) {
        if (status === 401 || status === 403) {
            this.messages.push({
                severity: 'warn',
                summary: 'Keine Berechtigung',
                detail: 'Sie verfügen nicht über die notwendige Berechtigung, diesen Service zu nutzen.'
            });
        } else if (status === 503) {
            this.messages.push({severity: 'warn', summary: 'Nicht verfügbar', detail: 'Dieser Service ist derzeit nicht verfügbar.'});
        } else if (status >= 400) {
            this.messages.push({severity: 'error', summary: 'Fehler', detail: 'Unerwarteter Fehler ' + status});
        }
    }
}
