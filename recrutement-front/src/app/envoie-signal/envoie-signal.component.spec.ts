import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnvoieSignalComponent } from './envoie-signal.component';

describe('EnvoieSignalComponent', () => {
  let component: EnvoieSignalComponent;
  let fixture: ComponentFixture<EnvoieSignalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnvoieSignalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnvoieSignalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
