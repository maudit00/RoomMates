import { Component, Input } from '@angular/core';
import { iBills } from '../../../../models/iBills';
import { iShifts } from '../../../../models/iShifts';
import { ShiftService } from '../../../../services/shift.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
@Input() bill!:iBills;
@Input() shift!:iShifts;
constructor(private shiftSvc:ShiftService){

}

deleteShift(id:number){
this.shiftSvc.delete(id).subscribe(res => res)
}
}
