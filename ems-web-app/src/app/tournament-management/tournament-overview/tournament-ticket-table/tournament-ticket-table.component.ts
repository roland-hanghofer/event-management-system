import {Component, Input, OnInit} from '@angular/core';
import {TournamentDay} from '../../../api/models/tournament-day';
import {Tournament} from '../../../api/models/tournament';
import {TournamentControllerImplService} from '../../../api/services/tournament-controller-impl.service';
import {Ticket} from '../../../api/models/ticket';

@Component({
    selector: 'app-tournament-ticket-table',
    templateUrl: './tournament-ticket-table.component.html',
    styleUrls: ['./tournament-ticket-table.component.css']
})
export class TournamentTicketTableComponent implements OnInit {
    @Input() tournament: Tournament;

    messages = [];
    days: Array<TournamentDay> = [];
    tickets: number[][] = [[0, 0, 0, 0]];
    ticketsGVT: Map<number, Ticket[]> = new Map();
    ticketsDS: Map<number, Ticket[]> = new Map();
    ticketsB: Map<number, Ticket[]> = new Map();
    ticketsPP: Map<number, Ticket[]> = new Map();


    constructor(private ts: TournamentControllerImplService) {
    }

    ngOnInit(): void {
        this.loadTournamentDetails(this.tournament.id);
    }

    loadTournamentDetails(id: number) {
        this.ts.getTournamentDaysUsingGETResponse(id).subscribe({
            next: (response) => {
                this.analyzeResponseStatus(response.status);
                this.days = response.body;
                this.days.forEach(d => this.loadTickets(d.id));
            },
            error: (error) => {
                this.analyzeResponseStatus(error.status);
            }
        });
    }

    loadTickets(dayId: number) {
        this.ts.getTicketForTournamentDayUsingGETResponse(dayId).subscribe({
            next: (response) => {
                this.analyzeResponseStatus(response.status);

                this.ticketsGVT.set(dayId, response.body.filter(t => t.type === 'GoldenVipTicket'));
                this.ticketsDS.set(dayId, response.body.filter(t => t.type === 'DaysaverTicket'));
                this.ticketsB.set(dayId, response.body.filter(t => t.type === 'BoxTicket'));
                this.ticketsPP.set(dayId, response.body.filter(t => t.type === 'PlayerspartyTicket'));


                this.tickets[0][0] += this.ticketsGVT.get(dayId).length;
                this.tickets[0][1] += this.ticketsDS.get(dayId).length;
                this.tickets[0][2] += this.ticketsB.get(dayId).length;
                this.tickets[0][3] += this.ticketsPP.get(dayId).length;
            },
            error: (error) => {
                this.analyzeResponseStatus(error.status);
            }
        });
    }

    getTicketCountForDay(tickets: Map<number, Ticket[]>, day: number) {
        return tickets.has(day) ? tickets.get(day).length : 0;
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
