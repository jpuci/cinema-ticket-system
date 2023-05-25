import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {Screening} from "../model/screening";
import {RepertoireService} from "../services/repertoire.service";
import {TakenSeat} from "../model/takenSeat";
import {SeatsService} from "../services/seats.service";

@Injectable({
  providedIn: 'root'
})
export class getTakenSeatsByScreeningIdResolver implements Resolve<TakenSeat[]> {

  constructor(private readonly seatsService : SeatsService ) { //repertoireService: RepertoireService
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TakenSeat[]> {
    const screeningId = +route.paramMap.get('screeningId')!;
    return this.seatsService.getTakenSeatsByScreeningId(screeningId);
  }
}
