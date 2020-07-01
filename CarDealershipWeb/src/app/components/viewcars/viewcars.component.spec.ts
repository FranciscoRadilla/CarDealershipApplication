import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewcarsComponent } from './viewcars.component';

describe('ViewcarsComponent', () => {
  let component: ViewcarsComponent;
  let fixture: ComponentFixture<ViewcarsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewcarsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewcarsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
