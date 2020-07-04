import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleManagementDeleteComponent } from './salle-management-delete.component';

describe('SalleManagementDeleteComponent', () => {
  let component: SalleManagementDeleteComponent;
  let fixture: ComponentFixture<SalleManagementDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleManagementDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleManagementDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
