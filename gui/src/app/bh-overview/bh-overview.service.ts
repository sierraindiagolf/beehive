import {Injectable} from '@angular/core';
import {Headers, Http, Response, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/toPromise';

import {Hive} from './hive';
import {Observable} from "rxjs";


@Injectable()
export class BhOverviewService {

  //private hiveurl = 'assets/mock.json';
  private hiveurl = '/hives';

  constructor(private http: Http) {
  }

  getHives(): Observable<Hive[]> {
    let headers = new Headers({ 'Authorization': "Basic YW5kcmVpQHkuY29tOm1hcmNlbA==" });
    let options = new RequestOptions({ headers: headers });
    return this.http
      .get(this.hiveurl, options)
      .map(response => response.json() as Hive[]);
  }
}
