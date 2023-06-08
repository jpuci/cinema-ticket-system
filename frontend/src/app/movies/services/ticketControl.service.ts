import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TicketControl} from "../model/ticketControl";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class TicketControlService {

  constructor(private readonly http: HttpClient) { }

  getTicketControlInfoByCode(code: String): Observable<TicketControl> {
    return this.http.get<TicketControl>(`${moviesApiPrefix}/getTicketControlInfoByCode/${code}`)
  }
}
