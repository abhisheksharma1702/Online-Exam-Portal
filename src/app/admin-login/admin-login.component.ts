import { Component, OnInit } from '@angular/core';
import { Form, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../appmodel/login';
import { AdminService } from '../service/admin.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})

export class AdminLoginComponent implements OnInit {
  form2:any
  adminlogin : Login = new Login();
  message: String | undefined;
  constructor(private adminService: AdminService, private router: Router,) {​​​​ }​​​​

  
  loginCheck() {​​​​
  console.log(this.adminlogin);

  this.adminService.login(this.adminlogin).subscribe(response => {
    if(response==null){
      Swal.fire({
        position: 'center',
        icon: 'warning',
        title: 'Service Down!',
        showConfirmButton: false,
        timer: 2000
      })
    }
    else
    if(response.status=="SUCCESS"){
    Swal.fire({
      position: 'top-right',
      icon: 'success',
      title: 'Succesfully Logged In',
      showConfirmButton: false,
      timer: 1500
    })
    }
    else{
      Swal.fire({
        position: 'top-right',
        icon: 'error',
        title: 'Wrong Credentials',
        showConfirmButton: false,
        timer: 1500
      })
    }

    console.log(response);

    if(response.status == 'SUCCESS') {​​​​

      sessionStorage.setItem('adminId',response.userId );

      sessionStorage.setItem('adminEmail',String(this.adminlogin.email) );

      this.router.navigate(['admin_dashboard']);

    }​​​​

    else

      this.message = response.message;

  }​​​​)

}​​​​


  ngOnInit() {
    this.form2 = new FormGroup (  
      {
        email: new FormControl('', [Validators.required, 
        Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$')]),
        password: new FormControl('', [Validators.required, 
          Validators.pattern('^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$')])
      }
    )
  }

}
