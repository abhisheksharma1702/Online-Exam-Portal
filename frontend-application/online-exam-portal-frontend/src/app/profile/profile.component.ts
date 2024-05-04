import { Component, OnInit } from '@angular/core';
import { SignedService } from '../service/signed.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
   user:any = null;
  constructor(private login: SignedService) { }

  ngOnInit(): void {

   this.login.getCurrentUser().subscribe(response =>{
    this.user=response;
   });


  }

  currentUser(){


  }

}
