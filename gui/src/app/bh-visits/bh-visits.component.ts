import { Component, OnInit } from '@angular/core';
import { BhVisitsService } from './bh-visits.service';

@Component({
  selector: 'app-bh-visits',
  templateUrl: './bh-visits.component.html',
  styleUrls: ['./bh-visits.component.scss']
})
export class BhVisitsComponent implements OnInit {

  hives: any;

  constructor(private bhOverviewService : BhVisitsService) {
  }

  ngOnInit() {
    this.bhOverviewService.getHives().subscribe(hives => this.hives = hives);
  }

}
