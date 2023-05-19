import {Screening} from "../model/screening";
import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {RepertoireService} from "../services/repertoire.service";

@Injectable({
  providedIn: 'root'
})
export class getScreeningByIdResolver implements Resolve<Screening> {

  constructor(private readonly repertoireService: RepertoireService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Screening> {
    const screeningId = +route.paramMap.get('screeningId')!;
    return this.repertoireService.getScreeningById(screeningId);
  }
}

