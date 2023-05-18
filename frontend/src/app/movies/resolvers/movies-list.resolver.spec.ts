import { TestBed } from '@angular/core/testing';

import { MoviesListResolver } from './movies-list.resolver';
import {RepertoireService} from "../services/movies.service";

describe('BookListResolver', () => {
  let resolver: MoviesListResolver;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: RepertoireService, useValue: {} }
      ]
    });
    resolver = TestBed.inject(MoviesListResolver);
  });

  it('should be created', () => {
    expect(resolver).toBeTruthy();
  });
});
