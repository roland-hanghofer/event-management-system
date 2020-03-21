import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {TournamentOverviewComponent} from './tournament-overview/tournament-overview.component';
import { TournamentTicketTableComponent } from './tournament-overview/tournament-ticket-table/tournament-ticket-table.component';

import {ApiModule} from '../api/api.module';

import {PanelModule} from 'primeng/panel';
import {AccordionModule} from 'primeng/accordion';
import {TableModule} from 'primeng/table';


@NgModule({
    declarations: [TournamentOverviewComponent, TournamentTicketTableComponent],
    imports: [
        CommonModule,
        BrowserModule,
        BrowserAnimationsModule,
        ApiModule,

        PanelModule,
        AccordionModule,
        TableModule
    ],
    exports: [
        TournamentOverviewComponent
    ]
})
export class TournamentManagementModule {
}
