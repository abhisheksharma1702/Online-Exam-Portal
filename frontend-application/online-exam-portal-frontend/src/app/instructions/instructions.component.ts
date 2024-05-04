
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-instructions',
  templateUrl: './instructions.component.html',
  styleUrls: ['./instructions.component.css']
})
export class InstructionsComponent implements OnInit {
  courseid:number;
  levelid: number;
  constructor(private route: ActivatedRoute) {
    this.courseid = parseInt(this.route.snapshot.params?.['courseId']);
    this.levelid = parseInt(this.route.snapshot.params?.['levelId']);
   }
  ngOnInit() {
  }
}

