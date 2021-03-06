import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SalleEventListComponent } from './salle-event-list/salle-event-list.component';
import { SalleEventDetailsComponent } from './salle-event-details/salle-event-details.component';
import { SalleManagementComponent } from './salle-management/salle-management.component';
import { HttpClientModule } from '@angular/common/http';

import localeFr from '@angular/common/locales/fr';
import { registerLocaleData } from '@angular/common';
import { SalleManagementAddComponent } from './salle-management-add/salle-management-add.component';
import { SalleManagementEditComponent } from './salle-management-edit/salle-management-edit.component';
import { SalleManagementDeleteComponent } from './salle-management-delete/salle-management-delete.component';
import { EnvoieSignalComponent } from './envoie-signal/envoie-signal.component';
registerLocaleData(localeFr);

@NgModule({
  declarations: [
    AppComponent,
    SalleEventListComponent,
    SalleEventDetailsComponent,
    SalleManagementComponent,
    SalleManagementAddComponent,
    SalleManagementEditComponent,
    SalleManagementDeleteComponent,
    EnvoieSignalComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule, FormsModule,
    AppRoutingModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: "fr-FR" }],
  bootstrap: [AppComponent]
})
export class AppModule { }
