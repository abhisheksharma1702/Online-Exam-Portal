// 


import { HttpClient } from '@angular/common/http';
import { Component, HostListener, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
// import Swal from 'sweetalert2/dist/sweetalert2.js';
import { Question } from '../appmodel/question';
import { AdminService } from '../service/admin.service';
import Swal from 'sweetalert2';
import { ngxCsv } from 'ngx-csv/ngx-csv';


@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  addQuestion:Question = new Question();
  form1: any;
  fileUploadUrl="http://localhost:8083/add/admin-restapi/question/upload";
  constructor(private http: HttpClient, private adminService: AdminService, private router: Router) { }



  ngOnInit() {
    this.form1 = new FormGroup(
      {
        course_id : new FormControl('', [Validators.required,
          Validators.pattern('/^\d{10}$/')]),

        level_id : new FormControl('', [Validators.required,
          Validators.pattern('/^\d{10}$/')]),

        question : new FormControl('', [Validators.required]),

        option_1 : new FormControl('', [Validators.required]),

        option_2 : new FormControl('', [Validators.required]),

        option_3 : new FormControl('', [Validators.required]),

        option_4 : new FormControl('', [Validators.required]),

        correct_option : new FormControl('', [Validators.required])

      }
    )
    

  }
 
  addingQuestion(){

    if(this.addQuestion.correct_option!=null && this.addQuestion.levelId!=null && this.addQuestion.option_1
      && this.addQuestion.option_2 && this.addQuestion.option_3 && this.addQuestion.option_4 && this.addQuestion.question!=null
      && this.addQuestion.courseId){
          this.adminService.addquestion(this.addQuestion).subscribe((data =>{
      console.log(data);
      if(data==null){
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Service Down!',
          showConfirmButton: false,
          timer: 2000
        })
      }
      else{
        Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Question Added Successfully',
        showConfirmButton: false,
        timer: 1500
      })
      }

     } ));
      }
    else{
      Swal.fire({
        position: 'top-end',
        icon: 'warning',
        title: 'Please fill all details',
        showConfirmButton: false,
        timer: 1500
      })
    }
    
    
    }
     
    rld(){
      window.location.reload();
     }
   
     // sample file download code starts here
    
     sample:any = [
      { 
        question_id: "",
        correct_option: "",
        course_id: "",
        level: "",
        option_1: "",
        option_2: "",
        option_3: "",
        option_4: "",
        question: ""
      },
      { 
        question_id:"",
        correct_option: "",
        course_id: "",
        level: "",
        option_1: "",
        option_2:  "correct_option, options and question Should be strats with english alphabet ",
        option_3: "",
        option_4: "",
        question: "",
      },
      {
        question_id:"",
        correct_option: "",
        course_id: "",
        level: "",
        option_1: "",
        option_2:  "question_id, level and course_id should be a number",
        option_3: "",
        option_4: "",
        question: "",
      },
      {
        question_id:"",
        correct_option: "",
        course_id: "Java(101),Python(102),.NET(103),C(104),Php(105),C++(106)",
        level: "Easy(1),Medium(2),Hard(3)",
        option_1: "",
        option_2:  "",
        option_3: "",
        option_4: "",
        question: "",
      },
      {
        question_id: "",
        correct_option: "",
        course_id: "",
        level: "",
        option_1: "FOR EXAMPLE",
        option_2: "",
        option_3: "",
        option_4: "",
        question: ""
      },
      {
        question_id: 1,
        correct_option: "framework",
        course_id: 101,
        level: 1,
        option_1: "Language",
        option_2: "interface",
        option_3: "verb",
        option_4: "framework",
        question: "What is collection in Java?",
      }
     
    ];
     
     
    
  sampleFile(){
    var options = { 
      fieldSeparator: ',',
      quoteStrings: '"',
      decimalseparator: '.',
      showLabels: true, 
      showTitle: true,
      title: 'Sample Format of file to upload',
      useBom: true,
      noDownload: false,
      headers: ["question_id", "correct_option", "course_id", "level","option_1", "option_2","option_3","option_4","question"]
    };
   
   new ngxCsv(this.sample,"sample file", options);
  }
  


  file:any



  selectFile(event:any){
    this.file=event.target.files[0];
     console.log(this.file);
   }

  

  uploadFile(){
  let formData=new FormData();
    formData.append("file",this.file);
 this.http.post(this.fileUploadUrl,formData).subscribe(
      (data=>{
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Questions in File Added',
          showConfirmButton: false,
          timer: 1500
        })
      }
        )
    )



  }

}


