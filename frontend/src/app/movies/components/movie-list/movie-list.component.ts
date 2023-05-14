import { Component } from '@angular/core';
import { Movie } from '../../model/movie';
import { ActivatedRoute } from '@angular/router';
import {MoviesService} from "../../services/movies.service";

@Component({
  selector: 'bs-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss']
})
export class MovieListComponent {

  readonly movies: Movie[];

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly moviesService: MoviesService,
    ) {
    this.movies = this.activatedRoute.snapshot.data['movies'];

  }

  ngOnInit() {
    this.moviesService.getAllMovies().subscribe();
  }
}
