import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';

import { UserManagementModule} from './user-management/user-management.module';
import { DashboardModule} from './dashboard/dashboard.module';
import { TournamentManagementModule} from './tournament-management/tournament-management.module';
import {FullCalendarModule} from 'primeng/fullcalendar';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        AppRoutingModule,
        BrowserModule,
        BrowserAnimationsModule,
        HttpClientModule,
        UserManagementModule,
        DashboardModule,
        TournamentManagementModule,
        FullCalendarModule

    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
