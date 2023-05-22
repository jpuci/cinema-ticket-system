import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from "./movies/components/movie-list/movie-list.component";
import { MoviesListResolver } from "./movies/resolvers/movies-list.resolver";
import {MovieDetailsComponent} from "./movies/components/movie-details/movie-details.component";
import {GetMovieByIdResolver} from "./movies/resolvers/get-movie-by-id.resolver";
import { getScreeningByMovieIdResolver } from "./movies/resolvers/get-screenings-by-movie-id.resolver";
import {getScreeningsTodayResolver} from "./movies/resolvers/get-screenings-todayresolver";
import {BuyTicketComponent} from "./movies/components/buy-ticket/buy-ticket.component";
import {getScreeningByIdResolver} from "./movies/resolvers/get-screening-by-id.resolver";
import {GetRowsByHallIdResolver} from "./movies/resolvers/get-rows-by-hall-id.resolver";
import {getTakenSeatsByScreeningIdResolver} from "./movies/resolvers/get-taken-seats-by-screening-id-resolver";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/movies'
  },
  {
    path: 'movies',
    component: MovieListComponent,
    resolve: {
      movies: MoviesListResolver,
      screenings: getScreeningsTodayResolver
    }
  },
  {
    path: 'movies/:movieId/details',
    component: MovieDetailsComponent,
    resolve: {
      movie: GetMovieByIdResolver,
      screenings: getScreeningByMovieIdResolver,
    }
  },

  {
    path: 'movies/:screeningId/:hallId/book',
    component: BuyTicketComponent,
    resolve: {
      screening: getScreeningByIdResolver,
      rows: GetRowsByHallIdResolver,
      takenSeats: getTakenSeatsByScreeningIdResolver
    }
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
