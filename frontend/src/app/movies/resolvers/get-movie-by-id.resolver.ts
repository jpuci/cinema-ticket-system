import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {MoviesService} from '../services/movies.service';
import { Movie } from '../model/movie';

@Injectable({
  providedIn: 'root'
})
export class GetMovieByIdResolver implements Resolve<Movie> {

  constructor(private readonly moviesService: MoviesService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Movie> {
    const movieId = +route.paramMap.get('movieId')!;
    return this.moviesService.getMovieById(movieId);
  }
}
