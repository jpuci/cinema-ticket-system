import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";
import {OrderService} from "../services/order.service";
import {Code} from "../model/code";

@Injectable({
  providedIn: 'root'
})
export class GetCodeByOrderIdResolver implements Resolve<Code> {

  constructor(private readonly orderService: OrderService) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Code> {
    const orderId = +route.paramMap.get('orderId')!;
    return this.orderService.getCodeByOrderId(orderId);
  }
}
