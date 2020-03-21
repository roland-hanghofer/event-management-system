import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TournamentTicketTableComponent } from './tournament-ticket-table.component';

describe('TournamentDayTicketTableComponent', () => {
  let component: TournamentTicketTableComponent;
  let fixture: ComponentFixture<TournamentTicketTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TournamentTicketTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TournamentTicketTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
