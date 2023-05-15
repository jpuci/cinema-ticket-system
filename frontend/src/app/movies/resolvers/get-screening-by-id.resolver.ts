import {Screening} from "../model/screening";
import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import { MoviesService } from '../services/movies.service';


@Injectable({
  providedIn: 'root'
})
export class getScreeningByIdResolver implements Resolve<Screening> {

  constructor(private readonly moviesService: MoviesService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Screening> {
    const screeningId = +route.paramMap.get('screeningId')!;
    return this.moviesService.getScreeningById(screeningId);
  }
}

