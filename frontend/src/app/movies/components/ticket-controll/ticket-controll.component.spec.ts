import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketControllComponent } from './ticket-controll.component';

describe('TicketControllComponent', () => {
  let component: TicketControllComponent;
  let fixture: ComponentFixture<TicketControllComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TicketControllComponent]
    });
    fixture = TestBed.createComponent(TicketControllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
