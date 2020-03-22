import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {TournamentManagementComponent} from './tournament-management.component';
import {TournamentOverviewComponent} from './tournament-overview/tournament-overview.component';
import {AddTournamentComponent} from './add-tournament/add-tournament.component';

const routes: Routes = [
    {
        path: 'tournaments', component: TournamentManagementComponent,
        children: [
            {                path: '',                 component: TournamentOverviewComponent            },
            {                path: 'add',                 component: AddTournamentComponent            }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TournamentManagementRoutingModule {
}
