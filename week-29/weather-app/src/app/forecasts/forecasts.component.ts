import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forecasts',
  templateUrl: './forecasts.component.html',
  styleUrls: ['./forecasts.component.css']
})
export class ForecastsComponent implements OnInit {
  private cities: string[] = ['Barcelona', 'Budapest', 'London', 'Washington', 'Londrina'];

  constructor() { }

  ngOnInit() {
  }

  getTopCities(): string[]{
    return this.cities;
  }
}
