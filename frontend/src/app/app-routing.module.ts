import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from "./movies/components/movie-list/movie-list.component";
import { MoviesListResolver } from "./movies/resolvers/movies-list.resolver";
import {MovieDetailsComponent} from "./movies/components/movie-details/movie-details.component";
import {MovieGetByIdResolver} from "./movies/resolvers/movie-get-by-id.resolver";
import { findScreeningByMovieIdResolver } from "./movies/resolvers/get-screenings-by-movie-id.resolver";
import {findScreeningTodayResolver} from "./movies/resolvers/get-screenings-todayresolver";
import {BuyTicketComponent} from "./movies/components/buy-ticket/buy-ticket.component";
import {getScreeningByIdResolver} from "./movies/resolvers/get-screening-by-id.resolver";

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
      screenings: findScreeningTodayResolver
    }
  },
  {
    path: 'movies/:movieId/details',
    component: MovieDetailsComponent,
    resolve: {
      movie: MovieGetByIdResolver,
      screenings: findScreeningByMovieIdResolver,
    }
  },

  {
    path: 'movies/:screeningId/book',
    component: BuyTicketComponent,
    resolve: {
      screening: getScreeningByIdResolver
    }
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
