import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie';
import {Screening} from "../model/screening";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private readonly http: HttpClient) { }

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(`${moviesApiPrefix}/getMovies`);
  }

  getMovieById(id: number): Observable<Movie> {
    return this.http.get<Movie>(`${moviesApiPrefix}/getMovieById/${id}`)
  }

  // getScreeningsByMovieId(movie_id: Number): Observable<Screening[]> {
  //   return this.http.get<Screening[]>(`${moviesApiPrefix}/getRepertoireByMovieId/${movie_id}`)
  // }
  // getScreeningsToday(): Observable<Screening[]> {
  //   return this.http.get<Screening[]>(`${moviesApiPrefix}/getRepertoireToday`)
  // }
  // getScreeningById(id: Number): Observable<Screening> {
  //   return this.http.get<Screening>(`${moviesApiPrefix}/getRepertoireById/${id}`)
  // }
}
