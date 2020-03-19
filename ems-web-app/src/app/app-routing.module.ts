import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TournamentOverviewComponent} from './tournament-management/tournament-overview/tournament-overview.component';



const routes: Routes = [
    {path: '', pathMatch: 'full', redirectTo: 'tournaments'},
    {path: 'tournaments', component: TournamentOverviewComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
