import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import { MoviesService } from '../services/movies.service';
import {Screening} from "../model/screening";

@Injectable({
  providedIn: 'root'
})
export class findScreeningTodayResolver implements Resolve<Screening[]> {

  constructor(private readonly moviesService: MoviesService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Screening[]> {
    return this.moviesService.getRepertoireToday();
  }
}
