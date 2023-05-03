import { Component, OnInit } from '@angular/core';
import { Route, Router, Routes } from '@angular/router';

@Component({
  selector: 'app-productbacklog-home',
  templateUrl: './productbacklog-home.component.html',
  styleUrls: ['./productbacklog-home.component.css']
})
export class ProductbacklogHomeComponent implements OnInit  {

  constructor( private router : Router){
  }

  ngOnInit(){
    
  }
  handleCreateProduct(){
    this.router.navigate(['add']);
  }

  userStoryList(){
    this.router.navigate(['list']);
  }
  userStoryDetail(){
    this.router.navigate(['detail']);
  }

  userStoryReport(){
    this.router.navigate(['report']);
  }
}
