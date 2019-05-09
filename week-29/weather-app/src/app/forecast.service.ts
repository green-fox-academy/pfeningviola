import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Forecast } from './forecast';
import { FORECASTS } from './mock-forecasts';
import { DataFromServer} from './data-from-server';
import { map } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class ForecastService {
  private forecast: Forecast;
  private forecasts: Forecast[];

  constructor(private http: HttpClient) { }

  getForecasts(): Forecast[]{
    return FORECASTS;
  }

  createApiUrl(city: string): string {
    return 'http://api.openweathermap.org/data/2.5/weather?q=' + city + '&units=metric&appid=950a1193e2fdf2695dbf30415dc4cb4b';
  }

  getForecastFromAPI(city: string){
    return this.http.get(this.createApiUrl(city));
  }
}
