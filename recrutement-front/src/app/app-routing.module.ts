import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SalleEventListComponent } from './salle-event-list/salle-event-list.component';
import { SalleEventDetailsComponent } from './salle-event-details/salle-event-details.component';
import { SalleManagementComponent } from './salle-management/salle-management.component';
import { SalleManagementAddComponent } from './salle-management-add/salle-management-add.component';
import { SalleManagementEditComponent } from './salle-management-edit/salle-management-edit.component';
import { SalleManagementDeleteComponent } from './salle-management-delete/salle-management-delete.component';
import { EnvoieSignalComponent } from './envoie-signal/envoie-signal.component';


const routes: Routes = [
  { path: '', component: SalleEventListComponent },
  { path: 'salleEvents', component: SalleEventListComponent },
  { path: 'salleManagement', component: SalleManagementComponent },
  { path: 'salleManagementAdd', component: SalleManagementAddComponent },
  { path: 'salleManagementDelete/:id', component: SalleManagementDeleteComponent },
  { path: 'salleManagementEdit/:id', component: SalleManagementEditComponent },
  { path: 'listSalleEvent/:id', component: SalleEventDetailsComponent },
  { path: 'envoieSignal', component: EnvoieSignalComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
