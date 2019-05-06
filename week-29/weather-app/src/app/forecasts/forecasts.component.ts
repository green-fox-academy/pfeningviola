import { Component, OnInit } from '@angular/core';
import { Forecast } from '../forecast';
import { ForecastService } from '../forecast.service';

@Component({
  selector: 'app-forecasts',
  templateUrl: './forecasts.component.html',
  styleUrls: ['./forecasts.component.css']
})
export class ForecastsComponent implements OnInit {
  forecasts: Forecast[];

  constructor(private forecastService: ForecastService) { }

  getForecasts(): void {
    this.forecasts = this.forecastService.getForecasts();
  }

  ngOnInit() {
    this.getForecasts();
  }

}
