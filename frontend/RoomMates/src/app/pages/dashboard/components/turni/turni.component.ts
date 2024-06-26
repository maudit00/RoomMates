import { Component } from '@angular/core';
import { iShiftRequest, iShifts } from '../../../../models/iShifts';
import { ShiftService } from '../../../../services/shift.service';
import { AuthService } from '../../../../services/auth.service';
import { ShiftType } from '../../../../models/ShiftType.enum';

@Component({
  selector: 'app-turni',
  templateUrl: './turni.component.html',
  styleUrl: './turni.component.scss'
})
export class TurniComponent {
  shifts!:iShifts[];
  addMode:boolean = false;
  shiftType!:ShiftType;
  clone:iShiftRequest= {
    description:"",
    date:"",
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
    this.shiftSvc.shift$.subscribe(shift => {
      if (shift)
      this.shifts.push(shift)
    });
    this.shiftSvc.shiftRemoved$.subscribe(res => {
      if (res)
      this.shifts.filter(shift => shift.id === res.id)
    })
  }

  add(shiftReq:iShiftRequest){
    console.log(shiftReq);
    this.addMode = false;
    return this.shiftSvc.postNewShift(shiftReq).subscribe(shift => console.log(shift)), (err: any) => console.log(err) ;
  }

}
