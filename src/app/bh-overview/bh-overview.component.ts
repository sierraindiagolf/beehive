import { Component, OnInit } from '@angular/core';

import { BhOverviewService } from './bh-overview.service';
import {Hive} from "./hive";

@Component({
  selector: 'app-bh-overview',
  templateUrl: './bh-overview.component.html',
  styleUrls: ['./bh-overview.component.scss'],
  host: {
    '[fxFlex]': '',
    '[fxLayout]': 'column',
    '[fxFlexFill]': ''
  }
})
export class BhOverviewComponent implements OnInit {

  hives: Array<Hive>;

  constructor(private bhOverviewService : BhOverviewService) {
  }

  ngOnInit() {
    this.bhOverviewService.getHives().subscribe(hives => this.hives = hives);
  }

}
