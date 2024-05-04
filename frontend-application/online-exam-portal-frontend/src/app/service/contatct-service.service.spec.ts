import { TestBed } from '@angular/core/testing';

import { ContatctServiceService } from './contatct-service.service';

describe('ContatctServiceService', () => {
  let service: ContatctServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContatctServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
