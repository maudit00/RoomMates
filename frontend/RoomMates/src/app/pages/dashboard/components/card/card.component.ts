import { Component, Input } from '@angular/core';
import { iBills } from '../../../../models/iBills';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
@Input() bill!:iBills;

}
