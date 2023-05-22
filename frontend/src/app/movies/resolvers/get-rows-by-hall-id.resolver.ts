import { Injectable } from '@angular/core';
import {
  Resolve,
  RouterStateSnapshot,
  ActivatedRouteSnapshot
} from '@angular/router';
import { Observable } from 'rxjs';
import {Row} from "../model/row";
import {RowService} from "../services/row.service";

@Injectable({
  providedIn: 'root'
})
export class GetRowsByHallIdResolver implements Resolve<Row[]> {

  constructor(private readonly rowService: RowService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Row[]> {
    const hallId = +route.paramMap.get('hallId')!;
    console.log(hallId);
    return this.rowService.getRowsByHallId(hallId);
  }
}
