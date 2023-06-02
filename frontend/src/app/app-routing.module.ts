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
import {GetCodeByOrderIdResolver} from "./movies/resolvers/get-code-by-order-id.resolver";
import {CodeTicketComponent} from "./movies/components/code-ticket/code-ticket.component";
import {LoginComponent} from "./movies/components/login/login.component";
import {TicketControllComponent} from "./movies/components/ticket-controll/ticket-controll.component";
import {AuthGuard} from "./movies/security/AuthGuard";


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
  },

  {
    path: 'movies/:orderId/code',
    component: CodeTicketComponent,
    resolve: {
      code: GetCodeByOrderIdResolver
    }
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'check-tickets',
    component: TicketControllComponent,
    canActivate:[AuthGuard]
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
