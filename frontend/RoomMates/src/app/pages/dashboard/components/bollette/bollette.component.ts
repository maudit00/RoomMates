import { iShiftRequest } from './../../../../models/iShifts';
import { Component } from '@angular/core';
import { iBills } from '../../../../models/iBills';
import { AuthService } from '../../../../services/auth.service';
import { BolletteService } from '../../../../services/bollette.service';

@Component({
  selector: 'app-bollette',
  templateUrl: './bollette.component.html',
  styleUrl: './bollette.component.scss'
})
export class BolletteComponent {
  bills!:iBills[];
  constructor(private billsSvc:BolletteService, private authSvc:AuthService){
  }
    ngOnInit(){
      this.authSvc.user$.subscribe(user =>{
        console.log(user?.user);
        if(user)
       this.billsSvc.getAllBills(user?.user.id).subscribe(bills => {
      this.bills = bills.content
      console.log(this.bills);

    })
      });
  }
}
