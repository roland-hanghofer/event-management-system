import {Component, OnInit} from '@angular/core';
import {TournamentControllerImplService} from '../../api/services/tournament-controller-impl.service';
import {Tournament} from '../../api/models/tournament';
import {MessageService} from 'primeng/api';
import {BaseComponent} from '../../core/base/base.component';

@Component({
    selector: 'app-add-tournament',
    templateUrl: './add-tournament.component.html',
    styleUrls: ['./add-tournament.component.css'],
    providers: [MessageService]
})
export class AddTournamentComponent extends BaseComponent implements OnInit {
    successSummary = 'Turnier angelegt';
    successMessage = 'Turnier wurde erfolgreich hinzugefügt';

    tournament: Tournament = new class implements Tournament {
        endDate: string;
        id: number;
        name: string;
        startDate: string;
    };

    rangeDates: Date[] = [new Date(), new Date()];

    constructor(protected messageService: MessageService, private ts: TournamentControllerImplService) {
        super(messageService);
    }

    ngOnInit(): void {
    }

    addSingle() {
        this.messageService.add({severity:'success', summary:'Service Message', detail:'Via MessageService'});
    }

    add() {
        this.tournament.startDate = this.rangeDates[0].toJSON();
        this.tournament.endDate = this.rangeDates[this.rangeDates.length - 1].toJSON();
        this.ts.addTournamentUsingPOSTResponse(this.tournament).subscribe({
            next: (response) => {
                this.analyzeResponseStatus(response.status, this.successSummary, this.successMessage);
            },
            error: (error) => {
                this.analyzeResponseStatus(error.status);
            }
        });
    }
}
