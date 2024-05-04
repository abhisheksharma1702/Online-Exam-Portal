// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class AdminService {

//   constructor() { }
// }


import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConnectableObservable, Observable } from 'rxjs';
import { Login } from '../appmodel/login';
import { Question } from '../appmodel/question';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http: HttpClient) { }

  addquestion(addquestion: Question) : Observable<any> {
    
    let url = "http://localhost:8054/add/admin-restapi/add_question";
    return this.http.post(url, addquestion);
  }

  removequestion(questionid: number): Observable<any>{
    let url = "http://localhost:8054/add/admin-restapi/remove_question/"+questionid;
   return this.http.delete(url);
  }

  login(login:Login):Observable<any> {
    let url="http://localhost:8054/auth/admin-restapi/admin_login";
    return this.http.post(url, login);
  }
}
