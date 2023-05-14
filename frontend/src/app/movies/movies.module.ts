import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";
import {ReactiveFormsModule} from "@angular/forms";
import { NavigationComponent } from './components/navigation/navigation.component';
import {MatIconModule} from "@angular/material/icon";
import { CalendarComponent } from './components/movie-details/calendar/calendar.component';
import {CalendarModule, DateAdapter} from "angular-calendar";
import {adapterFactory} from "angular-calendar/date-adapters/date-fns";
// import movies from "/backend/movies.json"

@NgModule({
  declarations: [
    MovieListComponent,
    MovieDetailsComponent,
    NavigationComponent,
    CalendarComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    MatIconModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory })

  ],
  exports: [MatIconModule]

})
export class MoviesModule { }
