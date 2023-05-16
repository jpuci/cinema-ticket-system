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
export class findScreeningByMovieIdResolver implements Resolve<Screening[]> {

  constructor(private readonly moviesService: MoviesService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Screening[]> {
    const movieId = +route.paramMap.get('movieId')!;
    return this.moviesService.findScreeningByMovieId(movieId);
  }
}
