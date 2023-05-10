import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieListComponent } from "./movies/components/movie-list/movie-list.component";
import { MoviesListResolver } from "./movies/resolvers/movies-list.resolver";
import {MovieDetailsComponent} from "./movies/components/movie-details/movie-details.component";
import {MovieGetByIdResolver} from "./movies/resolvers/movie-get-by-id.resolver";

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
      movies: MoviesListResolver
    }
  },
  {
    path: 'movies/:movieId/details',
    component: MovieDetailsComponent,
    resolve: {
      movie: MovieGetByIdResolver
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
