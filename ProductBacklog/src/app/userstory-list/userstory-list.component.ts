import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductBacklogService } from '../product-backlog.service';

@Component({
  selector: 'app-userstory-list',
  templateUrl: './userstory-list.component.html',
  styleUrls: ['./userstory-list.component.css']
})
export class UserstoryListComponent implements OnInit {

  developerId = "";
  constructor(private router: Router,private productBacklogService : ProductBacklogService){
  }
  ngOnInit() {
    
  }

  sendTolistView(developerId1:string){
    this.productBacklogService.temp = developerId1;
    this.router.navigate(['show-list',developerId1]);
  }

}
