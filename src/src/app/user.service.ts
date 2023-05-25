import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './appmodel/login';
import { Register } from './appmodel/register';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(login: Login) : Observable<any> {
    
    let url = "http://localhost:8054/auth/user-restapi/login";
   return this.http.post<String>(url, login);
  }

  registerUser(register: Register) : Observable<any> {
    let url = "http://localhost:8054/auth/user-restapi/register";
    return this.http.post(url, register);
  }

}

