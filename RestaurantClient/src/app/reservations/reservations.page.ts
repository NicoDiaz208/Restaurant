import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/Entities/reservation';
import { Table } from 'src/Entities/table';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.page.html',
  styleUrls: ['./reservations.page.scss'],
})
export class ReservationsPage implements OnInit {
  private reservations:Reservation[] = [new Reservation(1,new Date('December 17, 1995 03:24:00'),"06642626121","NicoDiaz208@gmail.com")]
  public tables:Table[] = [new Table(1, null, 4), new Table(2, this.reservations, 5)];
  constructor() { }

  ngOnInit() {
  }

}
