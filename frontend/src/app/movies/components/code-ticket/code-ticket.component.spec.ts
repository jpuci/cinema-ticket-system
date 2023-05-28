import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CodeTicketComponent } from './code-ticket.component';

describe('CodeTicketComponent', () => {
  let component: CodeTicketComponent;
  let fixture: ComponentFixture<CodeTicketComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CodeTicketComponent]
    });
    fixture = TestBed.createComponent(CodeTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
