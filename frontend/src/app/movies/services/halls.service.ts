import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Halls} from "../model/halls";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class HallsService {

  constructor(private readonly http: HttpClient) { }

  getHallsById(halls_id: Number): Observable<Halls[]> {
    return this.http.get<Halls[]>(`${moviesApiPrefix}/getHallsById/${halls_id}`)
  }
}
