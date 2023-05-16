import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Screening} from "../../model/screening";

@Component({
  selector: 'bs-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.scss']
})
export class BuyTicketComponent {
  screening: Screening | undefined;

  constructor(private readonly activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.screening = this.activatedRoute.snapshot.data['screening'];
  }
}
