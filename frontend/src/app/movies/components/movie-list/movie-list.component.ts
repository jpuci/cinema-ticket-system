import { Component } from '@angular/core';
import { Movie } from '../../model/movie';
import { ActivatedRoute } from '@angular/router';
import {MoviesService} from "../../services/movies.service";
import {Screening} from "../../model/screening";

@Component({
  selector: 'bs-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.scss']
})


export class MovieListComponent {

  readonly movies: Movie[];
  readonly screenings: Screening[];

  screeningsDic: any = {};

  constructor(
    private readonly activatedRoute: ActivatedRoute,
    private readonly moviesService: MoviesService,
    ) {
    this.movies = this.activatedRoute.snapshot.data['movies']
    this.screenings = this.activatedRoute.snapshot.data['screenings']
  }

  ngOnInit() {
    this.moviesService.getAllMovies().subscribe();
    for (let screening of this.screenings) {
      let date = (new Date(screening.date))
      let minutes: string = date.getMinutes().toString();
      if (minutes === '0') {
        minutes += '0'
      }
      const hoursAndMinutes = date.getHours() + ':' + minutes;
      if (this.screeningsDic[screening.movie_id]) {
        this.screeningsDic[screening.movie_id]
          .push({hoursMinutes : hoursAndMinutes, id:screening.id, date: screening.date});
      } else {
        this.screeningsDic[screening.movie_id] =
          [{hoursMinutes : hoursAndMinutes, id:screening.id, date: screening.date}];
      }
      this.screeningsDic[screening.movie_id].sort((a: Dictionary, b: Dictionary) => {
        const dateA = a.date;
        const dateB = b.date;

        if (dateA < dateB) {
          return -1;
        } else if (dateA > dateB) {
          return 1;
        } else {
          return 0;
        }
      });

    }
  }

  datePassed(date: Date): boolean {
    let now = new Date()
    date = new Date(date)
    if (now > date) {
      return true
    }
    return false
  }
}

interface Dictionary {
  hoursMinutes: string;
  id: number;
  date: string;
}
