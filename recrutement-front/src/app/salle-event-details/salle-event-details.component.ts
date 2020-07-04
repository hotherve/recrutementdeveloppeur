import { Component, OnInit } from '@angular/core';
import { SalleEvent } from '../salle-event.class';
import { Salle } from '../salle.class';
import { SalleEventService } from '../salle-event.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { error } from 'protractor';

@Component({
  selector: 'app-salle-event-details',
  templateUrl: './salle-event-details.component.html',
  styleUrls: ['./salle-event-details.component.scss']
})
export class SalleEventDetailsComponent implements OnInit {

  id: number;
  salle: Observable<Salle>;
  salleEvents: Observable<SalleEvent[]>;

  constructor(private salleEventService: SalleEventService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.loadSalleEventList();
  }

  loadSalleEventList() {
    this.id = this.route.snapshot.params['id'];

    this.salleEventService.getSalleById(this.id).subscribe(data=>{console.log(data); this.salle=data;},error=>console.error(error));
    console.info("Salle : ", this.salle);

    this.salleEvents = this.salleEventService.getEventSalleList(this.id);

  }

  gotoList() {
    this.router.navigate(['salleEvents']);
  }
}
