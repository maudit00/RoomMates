import { NgModule } from '@angular/core';
import { CommonModule, JsonPipe } from '@angular/common';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardComponent } from './dashboard.component';
import { BolletteComponent } from './components/bollette/bollette.component';
import { CompitiComponent } from './components/compiti/compiti.component';
import { ProposteComponent } from './components/proposte/proposte.component';
import { TurniComponent } from './components/turni/turni.component';
import { DashHeaderComponent } from './components/dash-header/dash-header.component';
import { CardComponent } from './components/card/card.component';
import { FormsModule } from '@angular/forms';
import { NgbAlertModule, NgbDatepickerModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    DashboardComponent,
    BolletteComponent,
    CompitiComponent,
    ProposteComponent,
    TurniComponent,
    DashHeaderComponent,
    CardComponent,
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule,
    NgbDatepickerModule,
    NgbAlertModule,
    JsonPipe
  ]
})
export class DashboardModule { }
