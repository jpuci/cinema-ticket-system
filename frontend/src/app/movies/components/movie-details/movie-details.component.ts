import {Component, OnInit} from '@angular/core';
import { Movie } from '../../model/movie';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'ts-movie',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.scss']
})
export class MovieDetailsComponent implements OnInit{

  movie: Movie | undefined;

  constructor(private readonly activatedRoute: ActivatedRoute) {}

    ngOnInit(): void {
      this.movie = this.activatedRoute.snapshot.data['movie'];
    }
}
