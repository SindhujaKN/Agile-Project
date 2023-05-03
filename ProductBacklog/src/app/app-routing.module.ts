import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProductComponent } from './create-product/create-product.component';
import { UserstoryDetailsComponent } from './userstory-details/userstory-details.component';
import { UserstoryListComponent } from './userstory-list/userstory-list.component';
import { UserstoryReportComponent } from './userstory-report/userstory-report.component';
import { ProductbacklogHomeComponent } from './productbacklog-home/productbacklog-home.component';
import { UserstoryListShowComponent } from './userstory-list-show/userstory-list-show.component';
import { UserstoryDetilShowComponent } from './userstory-detil-show/userstory-detil-show.component';

const routes: Routes = [
  {path:'',component:ProductbacklogHomeComponent},
  {path:'add',component:CreateProductComponent},
  {path:'detail',component:UserstoryDetailsComponent},
  {path:'list',component:UserstoryListComponent},
  {path:'show-list/:developerId1',component:UserstoryListShowComponent},
  {path:'show-detail/:userStoryId1',component:UserstoryDetilShowComponent},
  {path:'report',component:UserstoryReportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
