import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Row} from "../model/row";
import {TakenSeat} from "../model/takenSeat";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private readonly http: HttpClient) { }

  getAuthentication(token: String): Observable<Boolean> {
    return this.http.get<Boolean>(`${moviesApiPrefix}/getAuthenticationByToken/${token}`)
  }

}
