import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {Screening} from "../model/screening";
import {RepertoireService} from "../services/repertoire.service";

@Injectable({
  providedIn: 'root'
})
export class getScreeningsTodayResolver implements Resolve<Screening[]> {

  constructor(private readonly repertoireService: RepertoireService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Screening[]> {
    return this.repertoireService.getScreeningsToday();
  }
}
