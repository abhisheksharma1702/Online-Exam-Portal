// 




import { Component, HostListener, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Register } from '../appmodel/register';
import { UserService } from '../user.service';
import Swal from 'sweetalert2';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  sessionUser : any = sessionStorage.getItem("userId");
  regform: any;
  register:Register = new Register();
 	message: any;
  constructor(private userService: UserService,private router:Router) { }

 logout() {
	debugger;
    sessionStorage.clear();
  }

  registerUser() {

    if(this.register.email!=null && this.register.full_name!=null && this.register.city!=null && this.register.date_of_birth!=null && this.register.mobile!=null && this.register.password!=null && this.register.state!=null){
      this.userService.registerUser(this.register).subscribe(response => {
   
     console.log( response);
      if(response.status=="SUCCESS"){
        Swal.fire({
          position: 'top-right',
          icon: 'success',
          title: 'Successfully Registered User with name: ' + this.register.full_name,
          showConfirmButton: false,
          timer: 1500
        })

        this.router.navigate(['user_login'])
      }
      else{
        this.message= response.message;
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: this.message+' with this email',
          showConfirmButton: false,
          timer: 1500
        })

      }
    })
    }
    else{
      Swal.fire({
        position: 'center',
        icon: 'warning',
        title: 'Please fill all the details',
        showConfirmButton: false,
        timer: 1500
      })
    }
  }

  sampleForm: any;
  @HostListener("window:beforeunload")
 selloutcanDeactivate(): Observable<boolean> | boolean {
     return (
         !this.sampleForm.dirty
     );
 }




  ngOnInit() {
    this.regform = new FormGroup (
    {
      email: new FormControl('', [Validators.required,
        Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]),

      password: new FormControl('', [Validators.required,
        Validators.pattern('^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$')]),

      fullName: new FormControl('', [Validators.required,
        Validators.pattern('^[a-zA-Z]+ [a-zA-Z]+$')]),

      mobile: new FormControl('', [Validators.required,
        Validators.pattern('^[0-9]{10}$')]),

      city: new FormControl('', [Validators.required]),

      state: new FormControl('', [Validators.required]),

      date_of_birth: new FormControl('', [Validators.required]),

      qualification: new FormControl('', [Validators.required,
       Validators.pattern('^[a-zA-Z ]*$') ]),

      year_of_completion: new FormControl('', [Validators.required,
        Validators.pattern('^[0-9]{4}$')])
    })
  }

}

