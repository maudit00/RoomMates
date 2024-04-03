import { Component } from '@angular/core';
import { iShifts } from '../../../../models/iShifts';
import { ShiftService } from '../../../../services/shift.service';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-turni',
  templateUrl: './turni.component.html',
  styleUrl: './turni.component.scss'
})
export class TurniComponent {
  shifts!:iShifts[];

  constructor(private shiftSvc:ShiftService, private authSvc:AuthService){
    this.authSvc.user$.subscribe(user =>{
      if(user)
      this.shiftSvc.getShiftByUser(user.user.id).subscribe(shift =>{
        this.shifts = shift.content;
      });
    })
  }
}
