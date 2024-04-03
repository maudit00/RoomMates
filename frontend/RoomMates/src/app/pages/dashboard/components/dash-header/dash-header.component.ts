import { Component } from '@angular/core';
import { iUser } from '../../../../models/iUser';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-dash-header',
  templateUrl: './dash-header.component.html',
  styleUrl: './dash-header.component.scss'
})
export class DashHeaderComponent {
  user!:iUser;
  constructor(private authSvc:AuthService){authSvc.user$.subscribe(user => {
    if (user)
    this.user = user.user
  });}
}
