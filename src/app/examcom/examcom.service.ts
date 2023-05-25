import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import{map,catchError} from 'rxjs/operators';
import { Examschedule } from '../examschedule';

@Injectable({
  providedIn: 'root'
})
export class ExamserService {
  private url:string= "http://localhost:8054/schedule/examschedule/";
  constructor(private http:HttpClient) {}

   func(exam:Examschedule, questionsize: number):Observable<any>{
    this.url= "http://localhost:8054/schedule/examschedule/" + questionsize;
   return this.http.post<any>(this.url,exam);
   }
}

