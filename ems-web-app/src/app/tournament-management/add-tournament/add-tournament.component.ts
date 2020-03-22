import {Component, OnInit} from '@angular/core';
import {TournamentControllerImplService} from '../../api/services/tournament-controller-impl.service';
import {Tournament} from '../../api/models/tournament';
//import {MessageService} from 'primeng';

@Component({
    selector: 'app-add-tournament',
    templateUrl: './add-tournament.component.html',
    styleUrls: ['./add-tournament.component.css']
})
export class AddTournamentComponent implements OnInit {

    messages = [];

    tournament: Tournament = new class implements Tournament {
        endDate: string;
        id: number;
        name: string;
        startDate: string;
    };

    rangeDates: Date[] = [new Date(), new Date()];

    constructor(private ts: TournamentControllerImplService/*, private messageService: MessageService*/) {
    }

    ngOnInit(): void {
    }

    add() {
        console.log('add');
        this.tournament.startDate = this.rangeDates[0].toJSON();
        this.tournament.endDate = this.rangeDates[this.rangeDates.length - 1].toJSON();
        console.log(this.rangeDates[0].toJSON(), this.tournament);
        this.ts.addTournamentUsingPOSTResponse(this.tournament).subscribe({
            next: (response) => {
                this.analyzeResponseStatus(response.status);
            },
            error: (error) => {
                this.analyzeResponseStatus(error.status);
            }
        });
    }

    analyzeResponseStatus(status: number) {
        console.log(status);
        /*if (status === 401 || status === 403) {
            this.messageService.add({
                severity: 'warn',
                summary: 'Keine Berechtigung',
                detail: 'Sie verfügen nicht über die notwendige Berechtigung, diesen Service zu nutzen'
            });
            this.messages.push({
                severity: 'warn',
                summary: 'Keine Berechtigung',
                detail: 'Sie verfügen nicht über die notwendige Berechtigung, diesen Service zu nutzen.'
            });
        } else if (status === 503) {
            this.messageService.add({
                severity: 'warn',
                summary: 'Nicht verfügbar',
                detail: 'Dieser Service ist derzeit nicht verfügbar.'
            });
            this.messages.push({severity: 'warn', summary: 'Nicht verfügbar', detail: 'Dieser Service ist derzeit nicht verfügbar.'});
        } else if (status >= 400) {
            this.messageService.add({
                severity: 'error',
                summary: 'Fehler',
                detail: 'Unerwarteter Fehler ' + status
            });
            this.messages.push({severity: 'error', summary: 'Fehler', detail: 'Unerwarteter Fehler ' + status});
        } else {
            this.messageService.add({
                severity: 'success',
                summary: 'Turnier hinzugefügt',
                detail: 'Turnier wurde erfolgreich hinzugefügt.'
            });
        }*/
    }
}
