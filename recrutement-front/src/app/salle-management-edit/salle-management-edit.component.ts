import { Component, OnInit } from '@angular/core';
import { Salle } from '../salle.class';
import { SalleEventService } from '../salle-event.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-salle-management-edit',
  templateUrl: './salle-management-edit.component.html',
  styleUrls: ['./salle-management-edit.component.scss']
})
export class SalleManagementEditComponent implements OnInit {
  id: number;
  salle: Salle;
  submitted = false;
  constructor(private route: ActivatedRoute, private salleEventService: SalleEventService, private router: Router) { }

  ngOnInit() {
    this.salle = new Salle();
    this.id = this.route.snapshot.params['id'];
    console.log("identifiant salle : " + this.id);
    if (!this.id) {
      console.error("pas d'identifiant retour liste");
      this.listeSalle();
    }
    this.salleEventService.getSalleById(this.id).subscribe(data => { console.log(data); this.salle = data; }, error => console.error(error));
    console.info("init salle: ", this.salle);

  }

  onSubmit() {
    this.submitted = true;
    this.miseaJourSalle();
  }

  miseaJourSalle() {
    this.salleEventService.modifSalle(this.salle)
      .subscribe(data => console.log(data), error => console.log(error));
    this.salle = new Salle();
    // this.listeSalle();
  }

  listeSalle(): void {
    this.router.navigate(['salleManagement']);
  }
}
