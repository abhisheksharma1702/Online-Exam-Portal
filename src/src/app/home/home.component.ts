import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }
  sessionUser : any = sessionStorage.getItem("userId");
  sessionAdmin : any = sessionStorage.getItem("adminId");

  ngOnInit(): void {
  }

}
