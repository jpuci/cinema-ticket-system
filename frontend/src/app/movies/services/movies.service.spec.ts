import { TestBed } from '@angular/core/testing';

import { RepertoireService } from './movies.service';
import {HttpClient} from "@angular/common/http";

describe('BooksService', () => {
  let service: RepertoireService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: HttpClient, useValue: {} }
      ]
    });
    service = TestBed.inject(RepertoireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
