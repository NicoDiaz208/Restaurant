import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MenuCardPageRoutingModule } from './menu-card-routing.module';

import { MenuCardPage } from './menu-card.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MenuCardPageRoutingModule
  ],
  declarations: [MenuCardPage]
})
export class MenuCardPageModule {}
