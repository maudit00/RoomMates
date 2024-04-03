import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';
import { ServiziComponent } from '../home/components/servizi/servizi.component';
import { BolletteComponent } from './components/bollette/bollette.component';
import { CompitiComponent } from './components/compiti/compiti.component';
import { TurniComponent } from './components/turni/turni.component';
import { ProposteComponent } from './components/proposte/proposte.component';

const routes: Routes = [
  {
    path: '',
    component: DashboardComponent
  },
  {
    path:'servizi',
    component:ServiziComponent
  },
  {
    path:'bollette',
    component:BolletteComponent
  },
  {
    path:'compiti',
    component:CompitiComponent
  },
  {
    path:'turni',
    component:TurniComponent
  },
  {
    path:'proposte',
    component:ProposteComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
