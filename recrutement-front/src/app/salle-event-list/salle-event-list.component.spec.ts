import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleEventListComponent } from './salle-event-list.component';

describe('SalleEventListComponent', () => {
  let component: SalleEventListComponent;
  let fixture: ComponentFixture<SalleEventListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleEventListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleEventListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
