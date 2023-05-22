import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Row} from "../model/row";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class RowService {

  constructor(private readonly http: HttpClient) { }

  getRowsByHallId(hall_id: Number): Observable<Row[]> {
    return this.http.get<Row[]>(`${moviesApiPrefix}/getRowsByHallId/${hall_id}`)
  }
}
