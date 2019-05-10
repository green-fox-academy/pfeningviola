import { Component, OnInit, Input } from '@angular/core';
import { Forecast } from '../forecast';
import { ForecastService } from '../forecast.service';
import { locateHostElement } from '@angular/core/src/render3/instructions';

@Component({
  selector: 'app-forecast',
  templateUrl: './forecast.component.html',
  styleUrls: ['./forecast.component.css']
})
export class ForecastComponent implements OnInit {
  forecast: Forecast;
  @Input() city: string;

  constructor(private forecastService: ForecastService) { }

  loadForecast(): void {    
      this.forecastService.getForecastFromAPI(this.city).subscribe(result => this.forecast = {city: result.name, country: result.sys.country, temperature: result.main.temp, weatherIconLink: '../assets/images/' + result.weather[0].icon + '.png'});
  }

  ngOnInit() {
    localStorage.setItem('Viola', 'hello');
    localStorage.getItem('Viola');
    this.loadForecast();
  }
}
