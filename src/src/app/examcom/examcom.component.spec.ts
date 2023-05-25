import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamcomComponent } from './examcom.component';

describe('ExamcomComponent', () => {
  let component: ExamcomComponent;
  let fixture: ComponentFixture<ExamcomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamcomComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExamcomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
