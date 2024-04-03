import { AuthService } from './../../services/auth.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  collapsed: boolean = false;
  isLogged: boolean = false;

constructor(private authSvc:AuthService){
  authSvc.isLogged$.subscribe(logged => this.isLogged = logged)
}

logout(){
this.authSvc.logout()
}

}
