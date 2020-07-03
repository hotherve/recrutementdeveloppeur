import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleManagementComponent } from './salle-management.component';

describe('SalleManagementComponent', () => {
  let component: SalleManagementComponent;
  let fixture: ComponentFixture<SalleManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
