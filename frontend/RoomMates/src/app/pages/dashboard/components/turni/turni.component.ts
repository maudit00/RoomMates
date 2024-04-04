import { Component } from '@angular/core';
import { iShiftRequest, iShifts } from '../../../../models/iShifts';
import { ShiftService } from '../../../../services/shift.service';
import { AuthService } from '../../../../services/auth.service';

@Component({
  selector: 'app-turni',
  templateUrl: './turni.component.html',
  styleUrl: './turni.component.scss'
})
export class TurniComponent {
  shifts!:iShifts[];
  addMode:boolean = false;
  clone:iShiftRequest= {
    description:"",
    date:new Date,
    idUser:0,
    shiftType:0
  }

  constructor(private shiftSvc:ShiftService, private authSvc:AuthService){
    this.authSvc.user$.subscribe(user =>{
      if(user)
      this.shiftSvc.getShiftByUser(user.user.id).subscribe(shift =>{
        this.shifts = shift.content;
      });
    })
  }

}
