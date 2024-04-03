import { HttpEvent, HttpHandler, HttpInterceptor, HttpInterceptorFn, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IAuthData } from '../models/i-auth-data';

@Injectable()
export class DefaultInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler):
    Observable<HttpEvent<any>> {
      console.log("ciao");

      let userString:string|null=localStorage.getItem('token');
      console.log(userString);

      if (!userString) return next.handle(req);
      let user:IAuthData= JSON.parse(userString);
      console.log(user);
      let newReq=req.clone({
        setHeaders: {
          Authorization:`Bearer ${user.token}`
        }
      })
    return next.handle(newReq);
  }
}
