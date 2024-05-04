import { TestBed } from '@angular/core/testing';

import { SignedService } from './signed.service';

describe('SignedService', () => {
  let service: SignedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SignedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
