import { Component, OnInit } from '@angular/core';
import { Salle } from '../salle.class';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { SalleEventService } from '../salle-event.service';

@Component({
  selector: 'app-salle-management',
  templateUrl: './salle-management.component.html',
  styleUrls: ['./salle-management.component.scss']
})
export class SalleManagementComponent implements OnInit {

  salles: Observable<Salle[]>;

  constructor(private salleEventService: SalleEventService, private router: Router) { }

  ngOnInit() {
    console.info("init component SalleManagement Component");
    this.getAllSalles();
  }

  getAllSalles() {
    console.info("Charge liste des salles");
    this.salles = this.salleEventService.getSalleList();
  }

  salleModif(id: number) {
    this.router.navigate(['salleManagementEdit', id]);
  }

  salleDelete(id: number) {
    this.router.navigate(['salleManagementDelete', id]);
  }

  ajoutSalle() {
    this.router.navigate(['salleManagementAdd']);
  }
}
