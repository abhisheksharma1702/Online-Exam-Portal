
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-report-success',
  templateUrl: './report-success.component.html',
  styleUrls: ['./report-success.component.css']
})
export class ReportSuccessComponent implements OnInit {

  levelid:number;

  constructor(private router:Router) { 
    this.levelid=parseInt(JSON.parse( sessionStorage.getItem("levelid")||'{}'));
  }

  ngOnInit() {
  }


  completed(){
    this.router.navigate(['userDashboard']);
  }
}

