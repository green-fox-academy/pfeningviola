import { Component, OnInit } from '@angular/core';
 
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  cities: string[] = ['Barcelona', 'Budapest', 'London', 'Londrina'];
 
  constructor() { }
 
  ngOnInit() {
  }
}
