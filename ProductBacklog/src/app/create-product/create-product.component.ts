import { Component, OnInit } from '@angular/core';
import { ProductHelper } from '../ProductHelper';
import { Router } from '@angular/router';
import { ProductBacklogService } from '../product-backlog.service';
import { Epic } from '../Epic';
import { UserStory } from '../UserStory';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent {
  projectCode : any;
  sprintId = 0;
  name = "";
  createdOn: any ;
  completedOn: any ;
  status = "";
  title = "";
  userStoryDetails = "";
  acceptanceCriteria = "";
  priority = "";
  UserCreatedOn: any;
  doneOn: any;
  assignedToDeveloperId = 0;
  storyPoint = "";
  statusU = "";
  epicId = 0;



 

  // constructor(private router: Router,private productBacklogService : ProductBacklogService){
  // }
  constructor(private http: HttpClient){
     }


     createProduct(projectCode: number,sprintId: number,name : string,createdOn : Date,
      completedOn: Date,status: string,title: string,userStoryDetails: string,
      acceptanceCriteria: string,priority: string,UserCreatedOn: any,doneOn: any,
      assignedToDeveloperId: number,storyPoint: string,statusU: string,epicId: number){    
    const postData = {
      "epic": {
        "projectCode": projectCode,
        "sprintID": sprintId,
        "name": name,
        "createdOn": createdOn,
        "completedOn": completedOn,
        "status": status
      },
      "story": [{        
        "title": title,
        "userStoryDetails": userStoryDetails,
        "acceptanceCriteria": acceptanceCriteria,
        "priority": priority,
        "createdOn": UserCreatedOn,
        "doneOn": doneOn,
        "assignedToDeveloperId": assignedToDeveloperId,
        "storyPoint": storyPoint,
        "status": statusU,
        "epicId": epicId
      }]
  
};
   
    this.http.post<any>("http://localhost:8085/productbacklog/create",postData).subscribe();
    alert("data inserted successfully");

  }

}
