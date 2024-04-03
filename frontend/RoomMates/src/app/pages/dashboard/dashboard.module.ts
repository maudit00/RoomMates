import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { BolletteComponent } from './components/bollette/bollette.component';
import { CompitiComponent } from './components/compiti/compiti.component';
import { ProposteComponent } from './components/proposte/proposte.component';
import { TurniComponent } from './components/turni/turni.component';
import { DashHeaderComponent } from './components/dash-header/dash-header.component';
import { CardComponent } from './components/card/card.component';


@NgModule({
  declarations: [
    DashboardComponent,
    BolletteComponent,
    CompitiComponent,
    ProposteComponent,
    TurniComponent,
    DashHeaderComponent,
    CardComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
  ]
})
export class DashboardModule { }
