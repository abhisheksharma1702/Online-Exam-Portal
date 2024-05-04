import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamSelectionComponent } from './exam-selection.component';

describe('ExamSelectionComponent', () => {
  let component: ExamSelectionComponent;
  let fixture: ComponentFixture<ExamSelectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamSelectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExamSelectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
