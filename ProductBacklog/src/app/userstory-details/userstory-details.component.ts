import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductBacklogService } from '../product-backlog.service';

@Component({
  selector: 'app-userstory-details',
  templateUrl: './userstory-details.component.html',
  styleUrls: ['./userstory-details.component.css']
})
export class UserstoryDetailsComponent implements OnInit {

  userStoryId = "";
  constructor(private router: Router,private productBacklogService : ProductBacklogService){
  }
  ngOnInit() {
    
  }

  showUserStoryDetail(userStoryId1:string){
    this.productBacklogService.temp = userStoryId1;
    this.router.navigate(['show-detail',userStoryId1]);
  }
}
