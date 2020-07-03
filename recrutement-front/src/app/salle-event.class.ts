import { Salle } from './salle.class';

export class SalleEvent {
    id: number;
    salleEvent: string;
    salle: Salle;
    occupee: boolean;
}