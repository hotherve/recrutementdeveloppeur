import { Component, OnInit } from '@angular/core';
import { SalleEventService } from '../salle-event.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Salle } from '../salle.class';

@Component({
  selector: 'app-salle-management-delete',
  templateUrl: './salle-management-delete.component.html',
  styleUrls: ['./salle-management-delete.component.scss']
})
export class SalleManagementDeleteComponent implements OnInit {
  id: number;
  salle: Salle = new Salle();
  submitted = false;

  constructor(private salleEventService: SalleEventService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.salle = new Salle();
    this.id = this.route.snapshot.params['id'];
    console.log("identifiant salle : " + this.id);
    if (!this.id) {
      console.error("pas d'identifiant retour liste");
      this.listeSalle();
    }
    // si la salle n'existe pas, je repart vers la liste
    this.salleEventService.getSalleById(this.id).subscribe(data => { console.log(data); this.salle = data; }, error => { console.error(error); this.listeSalle() });
    console.info("init salle: ", this.salle);
  }
  ngAfterViewChecked() {
    console.log("Tout est chargé", this.salle);
  }

  onSubmit() {
    this.submitted = true;
    this.effaceSalle();
  }

  effaceSalle() {
    this.salleEventService.effaceSalle(this.salle)
      .subscribe(data => console.log(data), error => console.log(error));
    this.salle = new Salle();
  }


  listeSalle(): void {
    this.router.navigate(['salleManagement']);
  }
}
