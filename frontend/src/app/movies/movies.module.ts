import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MovieListComponent } from './components/movie-list/movie-list.component';
import {HttpClientModule} from "@angular/common/http";
import {RouterModule} from "@angular/router";
import {MovieDetailsComponent} from "./components/movie-details/movie-details.component";
import {ReactiveFormsModule} from "@angular/forms";
// import movies from "/backend/movies.json"

@NgModule({
  declarations: [
    MovieListComponent,
    MovieDetailsComponent,
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule
  ]
})
export class MoviesModule { }
