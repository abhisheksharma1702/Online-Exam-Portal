import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignedService } from '../service/signed.service';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {

  constructor(private router: Router, private login: SignedService) { }
     user:any;
  sessionUser : any = sessionStorage.getItem("userId");
  sessionAdmin : any = sessionStorage.getItem("adminId");
  cwurl : any = window.location.href;

  logout() {
   sessionStorage.clear();
  //  location.reload();
   this.login.signedOut();
 }

  ngOnInit() {
   
    // this.login.getCurrentUser().subscribe(response => {
    //   this.user=response;
    // })
  }

 

  

}


