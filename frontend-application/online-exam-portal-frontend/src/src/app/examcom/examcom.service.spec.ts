import { TestBed } from '@angular/core/testing';

import { ExamcomService } from './examcom.service';

describe('ExamcomService', () => {
  let service: ExamcomService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamcomService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
