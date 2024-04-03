import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { ServiziComponent } from './components/servizi/servizi.component';
import { ChisonoComponent } from './components/chisono/chisono.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'servizi',
    component: ServiziComponent
  },
  {
    path: 'chisono',
    component: ChisonoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
