import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Screening} from "../../model/screening";
import {RowService} from "../../services/row.service";
import {Row} from "../../model/row";
import {map, scan, share, startWith, Subject} from "rxjs";
import {TakenSeat} from "../../model/takenSeat";
import {SeatsService} from "../../services/seats.service";



@Component({
  selector: 'ts-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.scss']
})
export class BuyTicketComponent {
  screening: Screening | undefined;

  rows: Row[] | undefined;

  takenSeats: TakenSeat[] | undefined;

  takenSeatsList: string[] = [];

  selectedSeats: Object[] = [];

  readonly noneMessage = "nothing";
  readonly selectSeat$ = new Subject<string>();

  registerSeats = (selected: Set<string>, seat: string) => {
    if (selected.has(seat)) {
      selected.delete(seat);
      this.selectedSeats.splice(this.selectedSeats.indexOf(seat), 1)
    } else {
      if (!this.isTaken(seat)){
        selected.add(seat);
        let row = seat.slice(0, 1)
        let number = seat.slice(1)
        let takenSeat = {repertoire_id: this.screening?.id, row_name: row, seat_number: number}
        this.selectedSeats.push(takenSeat)
      }
    }
    return selected;
  };

  readonly selectedMessage$ = this.selectSeat$.pipe(
    scan(this.registerSeats, new Set<string>()),
    startWith(new Set<string>()),
    map(set => (set.size ? Array.from(set).join(", ") : this.noneMessage)),
    share()
  );

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly seatsService: SeatsService
  ) {
    this.screening = this.activatedRoute.snapshot.data['screening'];
    this.rows = this.activatedRoute.snapshot.data['rows'];
    this.takenSeats = this.activatedRoute.snapshot.data['takenSeats'];
    if (this.takenSeats){
      for (let seat of this.takenSeats){
        this.takenSeatsList?.push(seat.row_name + seat.seat_number)
      }
    }
  }

  isTaken(seat: string): boolean {
    if (this.takenSeatsList.includes(seat)) {
      return true
    }
    return false

  }

  buyTickets(){
    this.seatsService.postTakenSeats(this.selectedSeats).subscribe()
  }


}
