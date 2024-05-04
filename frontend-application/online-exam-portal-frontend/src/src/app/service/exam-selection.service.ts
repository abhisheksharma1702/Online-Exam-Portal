// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class ExamSelectionService {

//   constructor() { }
// }

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ExamSelectionService {

  constructor(private http: HttpClient) { }

  examselection(courseid: number,userid:number) : Observable<any> {
    let url = "http://localhost:8054/report/user-restapi/exam_selection/"+courseid+"/"+userid;
   return this.http.get(url);
  }
  


}

