import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorboardComponent } from './doctorboard.component';

describe('DoctorboardComponent', () => {
  let component: DoctorboardComponent;
  let fixture: ComponentFixture<DoctorboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
