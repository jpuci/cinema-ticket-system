import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NavigationComponent } from './components/navigation/navigation.component';
import {MatIconModule} from "@angular/material/icon";
import { CalendarComponent } from './components/movie-details/calendar/calendar.component';
import {CalendarModule, DateAdapter} from "angular-calendar";
import {adapterFactory} from "angular-calendar/date-adapters/date-fns";
import { BuyTicketComponent } from './components/buy-ticket/buy-ticket.component';
import { CodeTicketComponent } from './components/code-ticket/code-ticket.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import {CookieService} from "ngx-cookie-service";
import { TicketControllComponent } from './components/ticket-controll/ticket-controll.component';
// import movies from "/backend/movies.json"

@NgModule({
  declarations: [
    MovieListComponent,
    MovieDetailsComponent,
    NavigationComponent,
    CalendarComponent,
    BuyTicketComponent,
    CodeTicketComponent,
    LoginComponent,
    LogoutComponent,
    TicketControllComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    MatIconModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    FormsModule

  ],
  exports: [MatIconModule],
  providers: [CookieService]

})
export class MoviesModule { }
