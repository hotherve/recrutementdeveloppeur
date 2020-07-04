import { Component, OnInit } from '@angular/core';
import { SalleEventService } from '../salle-event.service';
import { Router } from '@angular/router';
import { SalleEvent } from '../salle-event.class';
import { Observable } from 'rxjs';
import { Salle } from '../salle.class';
import { DatePipe } from '@angular/common';
import { SalleEventModel } from '../salle-eventModel.class';


@Component({
  selector: 'app-envoie-signal',
  templateUrl: './envoie-signal.component.html',
  styleUrls: ['./envoie-signal.component.scss'],
  providers: [DatePipe]
})
export class EnvoieSignalComponent implements OnInit {
  /** liste des salles pour dropdown */
  salles: Observable<Salle[]>;
  salleEvent: SalleEventModel = new SalleEventModel();
  submitted: boolean = false;
  now = new Date();
  dateString: string;
  signals: Array<string> = ["motion:on", "motion:off"];
  signal: string = "motion:on";
  id_room: string;

  constructor(private salleEventService: SalleEventService, private router: Router, private datePipe: DatePipe) { }

  ngOnInit() {
    console.log("Init envoie signal");
    this.dateString = this.datePipe.transform(this.now, "yyyy-MM-dd'T'HH:mm:ss")
    this.getAllSalles();
    // this.setDefaultValues();
  }

  setDefaultValues() {
    console.log("salles : ", this.salles)
    let i: number = 0;
    if (i == 0) {
      this.id_room = this.salles[i].id;
    }
  }

  getAllSalles() {
    console.info("Charge liste des salles");
    this.salleEventService.getSalleList().subscribe(data => { console.log("data chargées", data); this.salles = data; this.setDefaultValues() }, error => { console.error(error); });
  }

  nouveauSignal(): void {
    this.submitted = false;
    this.salleEvent = new SalleEventModel();
  }

  onSubmit() {
    
    this.salleEvent.time=this.dateString;
    this.salleEvent.event=this.signal;
    this.salleEvent.room_id= this.id_room.toString();
    console.info("Envoi d'un signal sur la salle",this.salleEvent);
    this.salleEventService.sendMessage(this.salleEvent).subscribe(data=>console.log("Message envoyé"),error=>console.error(error));
  }
}
