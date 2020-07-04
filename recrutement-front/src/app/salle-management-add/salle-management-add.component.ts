import { Component, OnInit } from '@angular/core';
import { Salle } from '../salle.class';
import { SalleEventService } from '../salle-event.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-salle-management-add',
  templateUrl: './salle-management-add.component.html',
  styleUrls: ['./salle-management-add.component.scss']
})
export class SalleManagementAddComponent implements OnInit {

  salle: Salle = new Salle();
  submitted = false;
  constructor(private salleEventService: SalleEventService, private router: Router) { }

  ngOnInit() {
    console.info("init composant ajout de salle")
  }

  nouvelleSalle(): void {
    this.submitted = false;
    this.salle = new Salle();
  }

  save() {
    this.salleEventService.ajouteSalle(this.salle).subscribe(data => console.log(data), error => console.error(error));
    this.salle = new Salle();

  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  listeSalle(): void {
    this.router.navigate(['salleManagement']);
  }
}
