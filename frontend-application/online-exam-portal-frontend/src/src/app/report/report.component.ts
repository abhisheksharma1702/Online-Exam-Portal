
import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ReportService } from '../service/report.service';
import { Route } from '@angular/router';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
    userid:any;
    public reports: any;
  constructor(private reportService:ReportService) { }

  ngOnInit() {
    this.userid = parseInt(JSON.parse(sessionStorage.getItem("userId")||'{}'));
    this.reportService.report(this.userid).subscribe(d =>this.reports=d);

    

  }
  

}

