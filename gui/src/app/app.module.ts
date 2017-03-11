import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {MaterialModule} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout'

import {AppComponent} from './app.component';
import {BhMapModule} from './bh-map/bh-map.module';
import {BhOverviewModule} from './bh-overview/bh-overview.module';
import {BhOverviewComponent} from "./bh-overview/bh-overview.component";

import {BhVisitsModule} from "./bh-visits/bh-visits.module";
import {BhVisitsComponent} from "./bh-visits/bh-visits.component";

import {RouterModule} from "@angular/router";


const appRoutes = [
  {path: 'overview', component: BhOverviewComponent},
  {path: 'visits', component: BhVisitsComponent},
  {
    path: '',
    redirectTo: '/overview',
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule,
    FlexLayoutModule.forRoot(),
    BhMapModule,
    BhOverviewModule,
    BhVisitsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
