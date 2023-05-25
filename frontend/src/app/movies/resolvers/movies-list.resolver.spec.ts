import { TestBed } from '@angular/core/testing';

import { MoviesListResolver } from './movies-list.resolver';
import {MoviesService} from "../services/movies.service";

describe('MoviesListResolver', () => {
  let resolver: MoviesListResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: MoviesService, useValue: {} }
      ]
    });
    resolver = TestBed.inject(MoviesListResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
