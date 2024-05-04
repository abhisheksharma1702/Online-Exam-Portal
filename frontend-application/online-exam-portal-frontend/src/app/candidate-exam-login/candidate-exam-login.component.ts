
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Login } from '../appmodel/login';
import { UserService } from '../user.service';
import { ExamService } from '../service/exam.service';
import { ExamSelectionService } from '../service/exam-selection.service';
import Swal from 'sweetalert2';
import { SignedService } from '../service/signed.service';


@Component({
  selector: 'app-candidate-exam-login',
  templateUrl: './candidate-exam-login.component.html',
  styleUrls: ['./candidate-exam-login.component.css']
})
export class CandidateExamLoginComponent implements OnInit {

//   sessionUser : any = sessionStorage.getItem("userId");
//   form1  : any;
//   login : Login = new Login();
//   message: any;
  userid: any;
  courseid: any;
  levelid: any;
  questionsize:any;

//   constructor(private userService: UserService, private router: Router,
//     private route: ActivatedRoute, private examservice : ExamSelectionService) {​​​​
//       this.courseid = parseInt(this.route.snapshot.params?.['courseId']);
//       this.levelid = parseInt(this.route.snapshot.params?.['levelId']);
//       this.questionsize =this.route.snapshot.params?.['questionsize'];
//     console.log(this.questionsize+"helllle")
//     }​​​


//   logout() {
//     sessionStorage.clear();
//   }
//   loginCheck() {​​​​
//   console.log(this.login);

//   this.userService.login(this.login).subscribe(response => {
//     console.log(response);

//     if(response==null){
//       Swal.fire({
//         position: 'center',
//         icon: 'warning',
//         title: 'Service Down!',
//         showConfirmButton: false,
//         timer: 2000
//       })
//     }
//     else{
//     if(response.status == 'SUCCESS') {
//       this.userid = parseInt(response.userId);​​​​
//       sessionStorage.setItem('userId', response.userId );
//       sessionStorage.setItem('questionsize',this.questionsize);
//       console.log("questionsize" + sessionStorage.getItem("questionsize"));
//       this.examservice.examselection(this.courseid,this.userid).subscribe(response=>{
//         if(response==false)
//         {
//         this.router.navigate(['exam_instructions/'+ this.courseid + '/'+ this.levelid]);
//         }
//         else
//         {
//           this.router.navigate(['userDashboard']);
//         }
//       });
//     }
//     }
//   })
// }

//   ngOnInit() {
//     this.form1 = new FormGroup (
//       {
//         email: new FormControl('', [Validators.required,
//         Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]),
//         password: new FormControl('', [Validators.required,
//         Validators.pattern('^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$')])
//       }
//     )
//   }

sessionUser : any= sessionStorage.getItem("userId");
form1  : any;
login : Login = new Login();
message: any;
loginData={
  username:'',
  password:''
}
constructor(private userService: UserService,private route: ActivatedRoute, private router: Router, private sign: SignedService,private examservice: ExamSelectionService ) {​
        this.courseid = parseInt(this.route.snapshot.params?.['courseId']);
      this.levelid = parseInt(this.route.snapshot.params?.['levelId']);
      this.questionsize =this.route.snapshot.params?.['questionsize'];
    console.log(this.questionsize+"helllle")​​​ }​​​

formSubmit(){
  this.sign.generateToken(this.loginData).subscribe(
    (data:any)=>{
      if(data!=null){
        localStorage.setItem('token',data.token);
        this.loginCheck();
      }
      else {
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Login Service Down!',
          showConfirmButton: false,
          timer: 2000
        })
      }
    },
     (error:any)=>{
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'Incorrect Username/Password ',
        showConfirmButton: false,
        timer: 2000
      })
     }
  );
}

logout() {
  sessionStorage.clear();
  this.sign.signedOut();
}

loginCheck() {

console.log(this.login);

this.userService.login(this.login).subscribe(response => {
  console.log(response);
  if(response==null){
    Swal.fire({
      position: 'center',
      icon: 'warning',
      title: 'Login Service Down!',
      showConfirmButton: false,
      timer: 2000
    })
  }
  else
  if(response.status == 'SUCCESS') {
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: 'Succesfully Logged In',
      showConfirmButton: false,
      timer: 1500
    })
    this.userid = parseInt(response.userId);​​​​
          sessionStorage.setItem('userId', response.userId );
          sessionStorage.setItem('questionsize',this.questionsize);
          console.log("questionsize" + sessionStorage.getItem("questionsize"));
          this.examservice.examselection(this.courseid,this.userid).subscribe(response=>{
            if(response==false)
            {
            this.router.navigate(['exam_instructions/'+ this.courseid + '/'+ this.levelid]);
            }
            else
            {
              Swal.fire({
                position: 'center',
                icon: 'warning',
                title: 'Link Expired...Pls Registered Again',
                showConfirmButton: false,
                timer: 1500
              })
              this.router.navigate(['/exam_selection']);
            }
          });
   

    sessionStorage.setItem('email',String(this.login.email) );
    sessionStorage.setItem('userId',response.userId );

    // this.router.navigate(['userDashboard']);

  }
  else{
    Swal.fire({
      position: 'center',
      icon: 'error',
      title: 'Incorrect Username/Password ',
      showConfirmButton: false,
      timer: 2000
    })
    this.ngOnInit();
    this.message = response.message;
  }
})
}

ngOnInit() {
  this.form1 = new FormGroup (
    {
      email: new FormControl('', [Validators.required,
      Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]),
      password: new FormControl('', [Validators.required,
      Validators.pattern('^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$')])
    }
  )
}


}


