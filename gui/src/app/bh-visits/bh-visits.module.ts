import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BhVisitsComponent } from './bh-visits.component';
import {MaterialRootModule} from "@angular/material";
import {BhVisitsService} from "./bh-visits.service";

@NgModule({
  imports: [
    CommonModule,
    MaterialRootModule
  ],
  declarations: [BhVisitsComponent],
  providers: [BhVisitsService]
})
export class BhVisitsModule { }
