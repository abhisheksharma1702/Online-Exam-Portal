// import { Component, OnInit } from '@angular/core';

// @Component({
//   selector: 'app-examcom',
//   templateUrl: './examcom.component.html',
//   styleUrls: ['./examcom.component.css']
// })
// export class ExamcomComponent implements OnInit {

//   constructor() { }

//   ngOnInit(): void {
//   }

// }

import { Data } from '@angular/router';
import { ExamserService } from './examcom.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Examschedule } from '../examschedule';
import Swal from 'sweetalert2';
import { Router, RouterLink } from '@angular/router';
@Component({
  selector: 'app-examcom',
  templateUrl: './examcom.component.html',
  styleUrls: ['./examcom.component.css']
})

export class ExamcomComponent implements OnInit {
  sessionUser : any= sessionStorage.getItem("userId");
  form1  : any;
  message: any;
  levelid: any;
  exam: Examschedule = new Examschedule();
  questionsize: any
  courseid = parseInt(JSON.parse(sessionStorage.getItem("courseid")|| '{}'));
  constructor(private examservice:ExamserService, private router:Router) {}
  ngOnInit(): void {

  }
  fun1(){
    console.log("CourseId"+this.courseid);
    this.exam.courseid = this.courseid;
    this.exam.levelid = parseInt(this.levelid);
    this.questionsize=10;
    console.log("Questionsize"+this.questionsize);
    this.examservice.func(this.exam, this.questionsize).subscribe(data=> {

      Swal.fire({
        position: 'top-right',
        icon: 'success',
        title: 'Exam Scheduled',
        showConfirmButton: false,
        timer: 1500
      })
      this.router.navigate(['userDashboard']);
      })
    }
  }


