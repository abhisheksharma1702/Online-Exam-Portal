import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpResponse, HttpRequest, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SignedService} from '../service/signed.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private login: SignedService){}
    intercept(
        req: HttpRequest<any>, 
        next: HttpHandler
        ): Observable<HttpEvent<any>> {
       
          //add the jwt token (localstorage) in each request
          var authReq=req;
          const token=this.login.getToken();
          console.log("inside interceptor");
          if(token!=null)
          {
              authReq=authReq.clone({
                setHeaders:{ Authorization: `Bearer ${token}`},
              });
          }
          return next.handle(authReq);
    }
  }

  export const AuthInterceptorProviders=[
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi: true,
    },
  ];
