import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { ChisonoComponent } from './components/chisono/chisono.component';
import { ServiziComponent } from './components/servizi/servizi.component';


@NgModule({
  declarations: [
    HomeComponent,
    ChisonoComponent,
    ServiziComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }
