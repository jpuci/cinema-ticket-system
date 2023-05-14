import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie';
import {Screening} from "../model/screening";

const moviesApiPrefix = '/api/movies';
const repertoireApiPrefix = '/api/repertoire';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private readonly http: HttpClient) { }

  getAllMovies(): Observable<Movie[]> {
    return this.http.get<Movie[]>(moviesApiPrefix);
  }

  findMovieById(id: number): Observable<Movie> {
    return this.http.get<Movie>(`${moviesApiPrefix}/${id}`)
  }

  searchMovieByText(text: String){
    return this.http.get<Movie[]>(`${moviesApiPrefix}?q=${text}`);
  }

  findScreeningByMovieId(movie_id: Number): Observable<Screening[]> {
    return this.http.get<Screening[]>(`${repertoireApiPrefix}/?movie_id=${movie_id}`)
  }
}
