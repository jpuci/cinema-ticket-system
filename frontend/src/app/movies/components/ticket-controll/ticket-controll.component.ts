import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TicketControlService} from "../../services/ticketControl.service";
import {TicketControl} from "../../model/ticketControl";
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'bs-ticket-controll',
  templateUrl: './ticket-controll.component.html',
  styleUrls: ['./ticket-controll.component.scss']
})
export class TicketControllComponent {

  ticketControl: TicketControl | undefined;

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly ticketControlService: TicketControlService,
    private readonly orderService: OrderService,
    private router: Router
  ) {
  }

  search(code: String) {
    this.ticketControlService.getTicketControlInfoByCode(code).subscribe(
      response => {
        this.ticketControl = response;
      },
      error => {
        this.ticketControl = undefined;
        this.validateTicket()
      }
    );
  }

  isTicketActive() {
    if (this.ticketControl != null) {
      console.log(this.ticketControl?.status == "active")
      return this.ticketControl.status == "active"
    } else return false
  }

  validateTicket() {
    if (this.ticketControl != null) {
      this.ticketControl.status = "checked"
      this.orderService.postOrderStatusUpdate(this.ticketControl.orderId, this.ticketControl.status).subscribe()
    }
  }
}
