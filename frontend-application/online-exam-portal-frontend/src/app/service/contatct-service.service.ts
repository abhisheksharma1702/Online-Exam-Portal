import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContatctServiceService {

  constructor(private http:HttpClient) { }

  contactSupport() : Observable<any> {
    let url = "http://localhost:8054/add/admin-restapi/questions/";
    return this.http.get(url);
  }

}
