import { TestBed } from '@angular/core/testing';

import { ExamSelectionService } from './exam-selection.service';

describe('ExamSelectionService', () => {
  let service: ExamSelectionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamSelectionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
