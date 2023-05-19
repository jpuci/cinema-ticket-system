import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {Halls} from "../model/halls";
import {HallsService} from "../services/halls.service";

@Injectable({
  providedIn: 'root'
})
export class GetHallsByIdResolver implements Resolve<Halls[]> {

  constructor(private readonly hallsService: HallsService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Halls[]> {
    const hallId = +route.paramMap.get('hallId')!;
    console.log(hallId);
    return this.hallsService.getHallsById(hallId);
  }
}
