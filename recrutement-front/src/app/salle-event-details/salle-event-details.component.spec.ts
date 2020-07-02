import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleEventDetailsComponent } from './salle-event-details.component';

describe('SalleEventDetailsComponent', () => {
  let component: SalleEventDetailsComponent;
  let fixture: ComponentFixture<SalleEventDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleEventDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleEventDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
