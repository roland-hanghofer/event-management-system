import {Component, OnInit} from '@angular/core';
import {Menu} from 'primeng/menu';
import {MenuItem} from 'primeng/api';

@Component({
    selector: 'app-tournament-management',
    templateUrl: './tournament-management.component.html',
    styleUrls: ['./tournament-management.component.css']
})
export class TournamentManagementComponent implements OnInit {

    items: MenuItem[];

    constructor() {
    }

    ngOnInit(): void {
        this.items = [
            {label: 'Übersicht', routerLink: ['/tournaments']},
            {label: 'Hinzufügen', icon: 'pi pi-fw pi-plus', routerLink: ['/tournaments/add']},
            {label: 'Open', icon: 'pi pi-fw pi-download'},
            {label: 'Undo', icon: 'pi pi-fw pi-refresh'}
        ];
    }

}
