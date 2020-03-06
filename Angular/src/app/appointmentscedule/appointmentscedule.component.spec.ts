import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentsceduleComponent } from './appointmentscedule.component';

describe('AppointmentsceduleComponent', () => {
  let component: AppointmentsceduleComponent;
  let fixture: ComponentFixture<AppointmentsceduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppointmentsceduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentsceduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
