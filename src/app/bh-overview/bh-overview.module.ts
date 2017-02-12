import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BhOverviewService} from "./bh-overview.service";
import { BhOverviewComponent } from './bh-overview.component';
import {MaterialRootModule} from "@angular/material";
import { BhHiveDirective } from './bh-hive.directive';
import {FlexLayoutModule} from '@angular/flex-layout'

@NgModule({
  imports: [
    CommonModule,
    MaterialRootModule,
    FlexLayoutModule.forRoot(),
  ],
  declarations: [BhOverviewComponent, BhHiveDirective],
  providers: [BhOverviewService]
})
export class BhOverviewModule { }
