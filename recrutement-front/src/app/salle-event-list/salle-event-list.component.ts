
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Observable } from 'rxjs';
import { SalleEvent } from '../salle-event.class';
import { SalleEventService } from '../salle-event.service';

@Component({
  selector: 'app-salle-event-list',
  templateUrl: './salle-event-list.component.html',
  styleUrls: ['./salle-event-list.component.scss']
})
export class SalleEventListComponent implements OnInit {

  salleEvents: Observable<SalleEvent[]>;

  constructor(private salleEventService : SalleEventService, private router : Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.salleEvents = this.salleEventService.getSalleEventList();
  }
  salleEventDetails(id: number){
    this.router.navigate(['listSalleEvent', id]);
  }

}
