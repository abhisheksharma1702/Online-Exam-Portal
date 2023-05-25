

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';
import { ExamService } from '../service/exam.service';
import { Question } from '../appmodel/question';

@Component({
  selector: 'app-remove-question',
  templateUrl: './remove-question.component.html',
  styleUrls: ['./remove-question.component.css']
})
export class RemoveQuestionComponent implements OnInit {

  question_id: any;
  form1: any;
  question_list: Question[] | undefined;
  course_id:any;
  level_id: any;

  constructor(private adminService: AdminService, private router: Router, private examService:ExamService) { }

  ngOnInit() {
    this.form1 = new FormGroup(
      {
      question_id : new FormControl('', [Validators.required,
        Validators.pattern('/^\d{10}$/')])
      }
    )
  }

  searchQuestion() {
    this.examService.getQuestions(this.course_id, this.level_id,0).subscribe(data => {
      this.question_list=data
    });

  }

  removingQuestion(question_id:any){
    this.adminService.removequestion(question_id).subscribe(response =>{
    })
    this.searchQuestion();
  }
}

