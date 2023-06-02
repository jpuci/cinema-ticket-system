import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Code} from "../model/code";

const moviesApiPrefix = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private readonly http: HttpClient) {
  }

  getCodeByOrderId(order_id: Number): Observable<Code> {
    return this.http.get<Code>(`${moviesApiPrefix}/getCodeByOrderId/${order_id}`)
  }

}
