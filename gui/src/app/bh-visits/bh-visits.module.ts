import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BhVisitsComponent } from './bh-visits.component';
import {MaterialRootModule} from "@angular/material";

@NgModule({
  imports: [
    CommonModule,
    MaterialRootModule
  ],
  declarations: [BhVisitsComponent]
})
export class BhVisitsModule { }
