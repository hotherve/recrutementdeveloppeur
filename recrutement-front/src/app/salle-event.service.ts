import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SalleEventService {


  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }

  getSalleEventList(): Observable<any> {
    let urlToGet = `${this.baseUrl}/salleEvents`;
    console.info("Service get evenement salle sur " + urlToGet);
    return this.http.get(urlToGet);
  }

  getSalleById(id: number): Observable<any> {
    let urlToGet = `${this.baseUrl}/salle/${id}`;
    console.info("Service get salle sur " + urlToGet);
    return this.http.get(`urlToGet`);
  }

  getEventSalleList(id: number): Observable<any> {
    let urlToGet = `${this.baseUrl}/salleEvents/${id}`;
    console.info("Les evenements de la salle " + urlToGet);
    return this.http.get(urlToGet);
  }
}
