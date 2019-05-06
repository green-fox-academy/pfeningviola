import { Component, OnInit } from '@angular/core';
import { Forecast } from '../forecast';
import { FORECASTS } from '../mock-forecasts';

@Component({
  selector: 'app-forecasts',
  templateUrl: './forecasts.component.html',
  styleUrls: ['./forecasts.component.css']
})
export class ForecastsComponent implements OnInit {
  forecasts = FORECASTS;

  constructor() { }

  ngOnInit() {
  }

}
