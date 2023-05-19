import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Screening} from "../../model/screening";
import {HallsService} from "../../services/halls.service";
import {Halls} from "../../model/halls";
import {map, scan, share, startWith, Subject} from "rxjs";

const registerSeats = (selected: Set<string>, seat: string) => {
  if (selected.has(seat)) {
    selected.delete(seat);
  } else {
    selected.add(seat);
  }
  return selected;
};

@Component({
  selector: 'ts-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.scss']
})
export class BuyTicketComponent {
  screening: Screening | undefined;

  halls: Halls[] | undefined;

  readonly noneMessage = "nothing";
  readonly selectSeat$ = new Subject<string>();

  readonly selectedMessage$ = this.selectSeat$.pipe(
    scan(registerSeats, new Set<string>()),
    startWith(new Set<string>()),
    map(set => (set.size ? Array.from(set).join(", ") : this.noneMessage)),
    share()
  );

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly hallsService: HallsService
  ) {
    this.screening = this.activatedRoute.snapshot.data['screening'];
    this.halls = this.activatedRoute.snapshot.data['halls'];
  }
}
