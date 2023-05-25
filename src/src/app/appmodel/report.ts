// import { HttpClient } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';
// // import { Report } from '../appmodel/report';
// import { ReportComponent } from '../report/report.component';

// @Injectable({
//   providedIn: 'root'
// })
// export class ReportService {
//   constructor(private http: HttpClient) { }

//   report(userid:any) : Observable<any> {
//     let url = "http://localhost:8054/report/user-restapi/report/"+userid;
//    return this.http.get<Report[]>(url);
//   }
// }


export class Report {
    constructor(marks: any,
        user_id: any,
        course_id: any,
        level_id: any,
        total_questions:any) {
        this.marks = marks;
        this.courseId = course_id;
        this.levelId = level_id;
        this.userId = user_id;
        this.totalQuestions = total_questions;
    }

    marks: any;
    userId: any;
    courseId: any;
    levelId:any;
    totalQuestions: any;

    public toString():String{
        return "user_id="+this.userId +"\nlevel_id="+this.levelId +"\ncourse_id="+this.courseId + "\nmarks="+this.marks 
            + "\ntotalquestions="+this.totalQuestions;
    }
}
