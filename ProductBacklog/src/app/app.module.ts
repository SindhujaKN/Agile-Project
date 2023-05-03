import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { UserstoryListComponent } from './userstory-list/userstory-list.component';
import { UserstoryDetailsComponent } from './userstory-details/userstory-details.component';
import { UserstoryReportComponent } from './userstory-report/userstory-report.component';
import { ProductbacklogHomeComponent } from './productbacklog-home/productbacklog-home.component';
import { UserstoryListShowComponent } from './userstory-list-show/userstory-list-show.component';
import { FormsModule } from '@angular/forms';
import {  HttpClientModule } from '@angular/common/http';
import { UserstoryDetilShowComponent } from './userstory-detil-show/userstory-detil-show.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateProductComponent,
    UserstoryListComponent,
    UserstoryDetailsComponent,
    UserstoryReportComponent,
    ProductbacklogHomeComponent,
    UserstoryListShowComponent,
    UserstoryDetilShowComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
