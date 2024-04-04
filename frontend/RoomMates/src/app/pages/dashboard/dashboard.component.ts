import { Component } from '@angular/core';
import { Router } from 'express-serve-static-core';
import { AuthService } from '../../services/auth.service';
import { iUser } from '../../models/iUser';
import { iShiftRequest } from '../../models/iShifts';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  user!:iUser;

  constructor(private authSvc: AuthService){
    authSvc.user$.subscribe(user => {
      if (user)
      this.user = user.user;
    });
  }

}
