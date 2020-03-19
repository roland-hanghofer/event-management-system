import {Component, OnInit} from '@angular/core';
import {TournamentControllerImplService} from '../../api/services/tournament-controller-impl.service';
import {Tournament} from '../../api/models/tournament';
import {TournamentDay} from '../../api/models/tournament-day';

@Component({
    selector: 'app-tournament-overview',
    templateUrl: './tournament-overview.component.html',
    styleUrls: ['./tournament-overview.component.css']
})


export class TournamentOverviewComponent implements OnInit {

    tournaments: Array<Tournament> = [];
    tournamentDays: Map<number, TournamentDay[]> = new Map();
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
                this.tournaments.forEach((t, idx, a) => this.loadTournamentDetails(t.id));
            },
            error: (error) => {
                this.analyzeResponseStatus(error.status);
            }
        });
    }

    loadTournamentDetails(id: number) {
        this.ts.getTournamentDaysAndTicketsUsingGETResponse(id).subscribe({
            next: (response) => {

                this.analyzeResponseStatus(response.status);

                //this.tournamentDays.set(id, Object.keys(response.body));
                console.log(response.body);
                console.log(this.tournamentDays);
                let x = Object.keys(response.body);
                console.log(x);
                let y = JSON.parse(Object.keys(response.body)[1]);
                console.log(y);
                //this.tournaments = this.tournaments.concat(response.body);
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
