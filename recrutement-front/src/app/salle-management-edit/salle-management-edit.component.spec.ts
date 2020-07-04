import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleManagementEditComponent } from './salle-management-edit.component';

describe('SalleManagementEditComponent', () => {
  let component: SalleManagementEditComponent;
  let fixture: ComponentFixture<SalleManagementEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleManagementEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleManagementEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
