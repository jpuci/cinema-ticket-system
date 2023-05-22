import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Row} from "../model/row";
import {TakenSeat} from "../model/takenSeat";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class SeatsService {

  constructor(private readonly http: HttpClient) { }

  getTakenSeatsByScreeningId(screening_id: Number): Observable<TakenSeat[]> {
    return this.http.get<TakenSeat[]>(`${moviesApiPrefix}/getTakenSeatsByRepertoireId/${screening_id}`)
  }
}
