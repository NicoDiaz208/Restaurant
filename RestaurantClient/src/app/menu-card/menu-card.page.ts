import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-menu-card',
  templateUrl: './menu-card.page.html',
  styleUrls: ['./menu-card.page.scss'],
})
export class MenuCardPage implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.snapshot.paramMap.get('id');
  }

}
