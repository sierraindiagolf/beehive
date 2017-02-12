/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { BhOverviewService } from './bh-overview.service';

describe('BhOverviewService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BhOverviewService]
    });
  });

  it('should ...', inject([BhOverviewService], (service: BhOverviewService) => {
    expect(service).toBeTruthy();
  }));
});
