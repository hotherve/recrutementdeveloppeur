import { TestBed } from '@angular/core/testing';

import { SalleEventService } from './salle-event.service';

describe('SalleEventService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SalleEventService = TestBed.get(SalleEventService);
    expect(service).toBeTruthy();
  });
});
