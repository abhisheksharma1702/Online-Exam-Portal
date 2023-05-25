import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SignedService {

  constructor(private http: HttpClient) { }

  //generate token
  public generateToken(loginData:any){
    let url = "http://localhost:8054/auth/user-restapi/generate-token"
    return this.http.post(url,loginData);
  }

  //login user:set token in localstorage
  public loginUser(token:any){
    localStorage.setItem('token',token);
    return true;
  }

  //islogin: user logged in or not
  public isLogin(){
    let tokenstr=localStorage.getItem("token");
    if(tokenstr==undefined || tokenstr=='' || tokenstr==null){
      return true;
    }
    else{
      return false;
    }
  }

  //logout: remove token from local storage

  public signedOut(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }
  //get token
  public getToken(){
    return localStorage.getItem('token');
  }

  //save user details

  public setUser(user:any){
    localStorage.setItem("user",JSON.stringify(user));
  }

  public getCurrentUser(){
    let url = "http://localhost:8054/auth/user-restapi/current-user";
    return this.http.get(url);
  }

  // Generate Support Ticket
  contactSupport(data: any){
    console.log("Inside service");
    let url = "http://localhost:8054/schedule/examschedule/support";
    return this.http.post(url, data);
   }
}
