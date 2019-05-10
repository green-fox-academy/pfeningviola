import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-city-details',
  templateUrl: './city-details.component.html',
  styleUrls: ['./city-details.component.css']
})
export class CityDetailsComponent implements OnInit {
  city:string;

  constructor(private route: ActivatedRoute,   
    private location: Location) { }

  ngOnInit() {
    this.getCityNameFromPath();
  }

  getCityNameFromPath(): void{
    this.city = this.route.snapshot.paramMap.get('city');
  }

  goBack(): void{
    this.location.back();
  }
}
