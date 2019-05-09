export class DataFromServer{
    coord: {lon:number; lat:number};
    weather: {id: number; main: string; description: string; icon: string}[];
    base: string;
    main: {temp: number; pressure: number; humidity: number; temp_min: number; temp_max: number};
    wind: {speed: number; degree: number};
    clouds: {all: number};
    rain:{};
    dt: number;
    sys: {type: number; id: number; message: number; country: string; sunrise: number; sunset: number};
    id: number;
    name: string;
    cod: number
}