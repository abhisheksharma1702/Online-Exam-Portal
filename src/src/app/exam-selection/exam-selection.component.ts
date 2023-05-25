import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import {ExamSelectionService} from '../service/exam-selection.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-exam-selection',
  templateUrl: './exam-selection.component.html',
  styleUrls: ['./exam-selection.component.css']
})
export class ExamSelectionComponent implements OnInit {

  userid: any;

  constructor(private router:Router,private examservice: ExamSelectionService) {

  }

  ngOnInit() {
  }

register()
{
  this.router.navigate(['register']);
}
  selection(courseid:number){
      this.userid = parseInt(JSON.parse(sessionStorage.getItem("userId")|| '{}'));
      this.examservice.examselection(courseid,this.userid).subscribe(response=>{
        if(response==null){
          Swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Service Down',
            showConfirmButton: false,
            timer: 2000
          })
        }
        else
        if(response==false)
        {

          sessionStorage.setItem("courseid",String(courseid));
          sessionStorage.setItem("levelid",String(1));
          this.router.navigate(['register']);
        }
        else
        {
          Swal.fire({
            position: 'center',
            icon: 'warning',
            title: 'Exam Already Attempted!! Choose other languages.',
            showConfirmButton: false,
            timer: 2000
          })
        }
      });
  }
}

