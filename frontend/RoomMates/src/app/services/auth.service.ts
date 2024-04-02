import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { JwtHelperService } from '@auth0/angular-jwt';
import { BehaviorSubject, Observable, map, tap } from 'rxjs';
import { IRegister } from '../models/i-register';
import { IAuthData } from '../models/i-auth-data';
import { ILogin } from '../models/i-login';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient, private route:Router) {
    this.restoreSession()
  }

  registerUrl:string = `${environment.URL}/register`;
  loginUrl:string = `${environment.URL}/login`;
  jwt:JwtHelperService = new JwtHelperService();
  authSub = new BehaviorSubject<IAuthData | null>(null);

  user$ = this.authSub.asObservable();
  isLogged$ = this.user$.pipe(map(user =>!!user));


  register(user:IRegister):Observable<IAuthData> {
    return this.http.post<IAuthData>(this.registerUrl, user);
  }

  login(data:ILogin):Observable<IAuthData> {
  return this.http.post<IAuthData>(this.loginUrl, data)
  .pipe(tap(data =>{
    this.authSub.next(data);
    localStorage.setItem('token', JSON.stringify(data))
    this.autoLogOut(data.token)
  }
  ));
  }


  autoLogOut (jwtString:string) {
    const expDate = this.jwt.getTokenExpirationDate(jwtString) as Date;
    const expMs = expDate.getTime() - new Date().getTime();

    setTimeout(() => {
      this.logout();
    }, expMs);
  }

  logout() {
    this.authSub.next(null);
    localStorage.removeItem('token');
    this.restoreSession()
    this.route.navigate(['/auth/login']);
  }

  restoreSession (){
    const userJson: string | null = localStorage.getItem('token');
    if (!userJson) return
    const authData: IAuthData = JSON.parse(userJson);
    if (this.jwt.isTokenExpired(authData.token)) return

    this.authSub.next(authData);
    this.autoLogOut(authData.token);
  }


}
