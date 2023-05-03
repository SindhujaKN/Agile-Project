import { Component, OnInit } from '@angular/core';
import { UserStory } from '../UserStory';
import { ProductBacklogService } from '../product-backlog.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userstory-list-show',
  templateUrl: './userstory-list-show.component.html',
  styleUrls: ['./userstory-list-show.component.css']
})
export class UserstoryListShowComponent implements OnInit{

  userStory :any = [];

   constructor(private productBacklogService : ProductBacklogService, private router : Router, private route : ActivatedRoute ){
   }

  ngOnInit() {

   this.productBacklogService.getMyUserStory(this.productBacklogService.temp).subscribe(data=>{
     this.userStory=data;
     console.log(data);
  });
    
  }

}
