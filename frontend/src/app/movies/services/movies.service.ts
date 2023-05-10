import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie';

const moviesApiPrefix = '/api/movies';

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
}
