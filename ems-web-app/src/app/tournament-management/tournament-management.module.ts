import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';

import {TournamentManagementRoutingModule} from './tournament-management-routing.module';
import {TournamentOverviewComponent} from './tournament-overview/tournament-overview.component';
import {TournamentTicketTableComponent} from './tournament-overview/tournament-ticket-table/tournament-ticket-table.component';
import {TournamentManagementComponent} from './tournament-management.component';
import { AddTournamentComponent } from './add-tournament/add-tournament.component';

import {ApiModule} from '../api/api.module';

import {PanelModule} from 'primeng/panel';
import {AccordionModule} from 'primeng/accordion';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {MenuModule} from 'primeng/menu';
import {CalendarModule} from 'primeng/calendar';
//import {ToastModule} from 'primeng/toast';


@NgModule({
    declarations: [
        TournamentOverviewComponent,
        TournamentTicketTableComponent,
        TournamentManagementComponent,
        AddTournamentComponent],
    imports: [
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        ApiModule,
        FormsModule,

        TournamentManagementRoutingModule,

        PanelModule,
        AccordionModule,
        TableModule,
        ButtonModule,
        DialogModule,
        InputTextModule,
        MenuModule,
        CalendarModule/*,
        ToastModule*/
    ],
    exports: [
        TournamentOverviewComponent
    ]
})
export class TournamentManagementModule {
}
