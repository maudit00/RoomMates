import { Component, Input } from '@angular/core';
import { iBills } from '../../../../models/iBills';
import { iShifts } from '../../../../models/iShifts';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
@Input() bill!:iBills;
@Input() shift!:iShifts;


}
