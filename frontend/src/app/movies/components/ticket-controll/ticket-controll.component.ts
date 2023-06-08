import {Component} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TicketControlService} from "../../services/ticketControl.service";

@Component({
  selector: 'bs-ticket-controll',
  templateUrl: './ticket-controll.component.html',
  styleUrls: ['./ticket-controll.component.scss']
})
export class TicketControllComponent {

  ticketControl: any;

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly ticketControlService: TicketControlService,
    private router: Router
  ) {
  }

  search(code: String) {
    this.ticketControl = this.ticketControlService.getTicketControlInfoByCode(code);
  }

  isTicketActive() {
    return this.ticketControl.status == "active"
  }

  validateTicket() {
    this.ticketControl.status = "validated"
  }
}
