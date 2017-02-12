import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BhOverviewService} from "./bh-overview.service";
import { BhOverviewComponent } from './bh-overview.component';
import {MaterialRootModule} from "@angular/material";

@NgModule({
  imports: [
    CommonModule,
    MaterialRootModule
  ],
  declarations: [BhOverviewComponent],
  providers: [BhOverviewService]
})
export class BhOverviewModule { }
