import {Component, ChangeDetectionStrategy, OnInit} from '@angular/core';
import {CalendarView, CalendarEvent} from 'angular-calendar';
import {Subject} from "rxjs";
import {addWeeks, endOfDay, isBefore, subWeeks} from 'date-fns';
import {Screening} from "../../../model/screening";
import {ActivatedRoute, Router} from "@angular/router";
import {formatDate} from "@angular/common";
import {WeekViewTimeEvent} from 'calendar-utils';


@Component({
  selector: 'ts-calendar',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {
  view: CalendarView = CalendarView.Week;
  viewDate: Date = new Date();
  events: CalendarEvent[] = [];
  dayStartHour = 12;
  dayEndHour = 24;
  screenings: Screening[] | undefined;

  constructor(private readonly activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.screenings = this.activatedRoute.snapshot.data['screenings']
    if (this.screenings) {
      for (let scr of this.screenings) {
        let year = scr.date[0].toString()
        let month = scr.date[1].toString()
        if (scr.date[1].toString().length == 1) month = "0" + scr.date[1]
        let day = scr.date[2].toString()
        if (scr.date[2].toString().length == 1) day = "0" + scr.date[2]
        let hour = scr.date[3].toString()
        if (scr.date[3].toString().length == 1) hour = "0" + scr.date[3]
        let minutes = scr.date[4].toString()
        if (scr.date[4].toString().length == 1) minutes = "0" + scr.date[4]

        let dateString = year + "-" + month + "-" + day + "T" + hour + ":" + minutes + ":" + "00" // YYYY-MM-DDTHH:MM:SS
        let date = new Date(dateString)
        this.events.push({title: formatDate(date, 'HH:mm', 'en-US').toString(), start: date, id: scr.id})
      }
    }

  }

  previousWeek(): void {
    this.viewDate = subWeeks(this.viewDate, 1);
  }

  nextWeek(): void {
    this.viewDate = addWeeks(this.viewDate, 1);
  }

  public isEventPassed(event: CalendarEvent): boolean {
    const currentTime = new Date();
    return !isBefore(currentTime, event.start);
  }

  navigateToBuyView(event: CalendarEvent) {
    if (!this.isEventPassed(event)) {
      let hallId = this.screenings?.find(x => x.id == event.id)?.hallId;
      this.router.navigate([`/movies/${event.id}/${hallId}/book`]);
    }
  }
}
