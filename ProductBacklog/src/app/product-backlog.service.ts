import { Injectable } from '@angular/core';
import {HttpClient} from  '@angular/common/http';
import { UserStory } from './UserStory';
import { Observable, catchError } from 'rxjs';
import { ProductHelper } from './ProductHelper';

@Injectable({
  providedIn: 'root'
})
export class ProductBacklogService {
 temp : string = '';
  constructor(private http: HttpClient) { }



public createNewProduct(prductHelper: ProductHelper): Observable<ProductHelper>{
  return this.http.post<ProductHelper>("http://localhost:8085/productbacklog/create",prductHelper);
}

  public getMyUserStory(develperId:String): Observable<UserStory>{
    return this.http.get<UserStory>("http://localhost:8085/prductbacklog/userstories/"+develperId);
  }
  
public updateUserStory(id:String,userStory: UserStory): Observable<UserStory>{
  return this.http.put<UserStory>("http://localhost:8085/prductbacklog/updateUserStory/"+id,userStory);
}
public viewProductBacklog(projectId:String): Observable<UserStory>{
  return this.http.get<UserStory>("http://localhost:8085/prductbacklog/report/"+projectId);
}

public viewUserStoryDetail(userStoryID:String): Observable<UserStory>{
  return this.http.get<UserStory>("http://localhost:8085/prductbacklog/userstory/"+userStoryID);
}


  
}
