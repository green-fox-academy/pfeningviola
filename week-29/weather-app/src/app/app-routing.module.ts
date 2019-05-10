import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForecastsComponent } from './forecasts/forecasts.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CityDetailsComponent }  from './city-details/city-details.component';

const routes: Routes = [
    { path: 'topcities', component: ForecastsComponent },
    { path: 'dashboard', component: DashboardComponent },
    { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
    { path: 'details/:city', component: CityDetailsComponent },
  ];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})

export class AppRoutingModule {}
