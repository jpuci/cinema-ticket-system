import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MoviesModule } from "./movies/movies.module";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatIconModule} from "@angular/material/icon";
import {HttpClientModule} from "@angular/common/http";
import { CalendarModule, DateAdapter} from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import {CookieService} from "ngx-cookie-service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    MoviesModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatIconModule,
    CalendarModule.forRoot({ provide: DateAdapter, useFactory: adapterFactory }),
    MatIconModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [MatIconModule],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
