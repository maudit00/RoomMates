import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { iPagesBills } from '../models/iPages';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { iUser } from '../models/iUser';

@Injectable({
  providedIn: 'root'
})
export class BolletteService {

  constructor(private http:HttpClient, private authSvc:AuthService) {
   }

  billsUrl:string = `${environment.URL}/bills/user`;

  getAllBills(userid:number):Observable<iPagesBills>{
    return this.http.get<iPagesBills>(`${this.billsUrl}/${userid}`);
  }

}
