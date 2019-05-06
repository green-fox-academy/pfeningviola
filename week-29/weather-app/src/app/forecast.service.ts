import { Injectable } from '@angular/core';
import { Forecast } from './forecast';
import { FORECASTS }from './mock-forecasts';

@Injectable({
  providedIn: 'root'
})
export class ForecastService {

  constructor() { }

  getForecasts(): Forecast[]{
    return FORECASTS;
  }
}
