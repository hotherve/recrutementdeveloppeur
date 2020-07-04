import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SalleEventModel } from './salle-eventModel.class';
import { Salle } from './salle.class';

@Injectable({
  providedIn: 'root'
})
export class SalleEventService {


  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  /* gestion des evenements */
  getSalleEventList(): Observable<any> {
    let urlToGet = `${this.baseUrl}/salleEvents`;
    console.info("Service get evenement de toutes les salle sur " + urlToGet);
    return this.http.get(urlToGet);
  }

  getSalleById(id: number): Observable<any> {
    let urlToGet = `${this.baseUrl}/salle/${id}`;
    console.info("Service get salle sur " + urlToGet);
    return this.http.get(urlToGet);
  }

  getEventSalleList(id: number): Observable<any> {
    let urlToGet = `${this.baseUrl}/salleEvents/${id}`;
    console.info("Les evenements de la salle " + urlToGet);
    return this.http.get(urlToGet);
  }

  /* gestion des salles */
  /* liste */
  getSalleList(): Observable<any> {
    let urlToGet = `${this.baseUrl}/salles`;
    console.info("Service get evenement salle sur " + urlToGet);
    return this.http.get(urlToGet);
  }
  /* ajout */
  ajouteSalle(salle: Salle) {
    let urlToPost = `${this.baseUrl}/salles`;
    console.info("Service post ajout salle sur " + urlToPost, salle);
    return this.http.post(urlToPost, salle);
  }
  /* modification */
  modifSalle(salle: Salle) {
    let urlToPut = `${this.baseUrl}/salles/${salle.id}`;
    console.info("Service post ajout salle sur " + urlToPut, salle);
    return this.http.put(urlToPut, salle);
  }
  /* effacement */
  effaceSalle(salle: Salle) {
    let urlToDelete = `${this.baseUrl}/salles/${salle.id}`;
    console.info("Service post ajout salle sur " + urlToDelete, salle);
    return this.http.delete(urlToDelete);
  }

  /* capteurs */
  /* envoi message d'un capteur */
  sendMessage(salleEventModel: SalleEventModel) {
    let urlToPost = `${this.baseUrl}/salleEvenements`;
    console.log("Envoi message capteur sur salle" + salleEventModel.room_id, salleEventModel)
    this.http.post(urlToPost, salleEventModel);
  }
}
