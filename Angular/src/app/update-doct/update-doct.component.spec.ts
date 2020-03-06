import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDoctComponent } from './update-doct.component';

describe('UpdateDoctComponent', () => {
  let component: UpdateDoctComponent;
  let fixture: ComponentFixture<UpdateDoctComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateDoctComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDoctComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
