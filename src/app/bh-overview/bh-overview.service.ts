import {Injectable} from '@angular/core';
import {Headers, Http, Response} from '@angular/http';
import 'rxjs/add/operator/toPromise';

import {Hive} from './hive';
import {Observable} from "rxjs";


@Injectable()
export class BhOverviewService {

  private hiveurl = 'assets/andrei_craciun.json';

  constructor(private http: Http) {
  }

  getHives(): Observable<Hive[]> {
    return this.http
      .get(this.hiveurl)
      .map(response => response.json() as Hive[]);
  }
}
