import { Component, OnInit } from '@angular/core';
import { ProductBacklogService } from '../product-backlog.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-userstory-detil-show',
  templateUrl: './userstory-detil-show.component.html',
  styleUrls: ['./userstory-detil-show.component.css']
})
export class UserstoryDetilShowComponent implements OnInit{

  userStory :any = [];

   constructor(private productBacklogService : ProductBacklogService, private router : Router, private route : ActivatedRoute ){
   }

  ngOnInit() {
    

   this.productBacklogService.viewUserStoryDetail(this.productBacklogService.temp).subscribe(data=>{
     this.userStory=data;
     console.log(data);
  });
    
  }
}
