import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalleManagementAddComponent } from './salle-management-add.component';

describe('SalleManagementAddComponent', () => {
  let component: SalleManagementAddComponent;
  let fixture: ComponentFixture<SalleManagementAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalleManagementAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalleManagementAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
