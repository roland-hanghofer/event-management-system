import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';

import { UserManagementModule} from './user-management/user-management.module';
import { DashboardModule} from './dashboard/dashboard.module';

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        AppRoutingModule,
        BrowserModule,

        UserManagementModule,
        DashboardModule

    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
