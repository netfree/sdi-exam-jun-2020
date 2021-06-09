import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Sensors } from './models/sensors.model';

@Injectable({
  providedIn: 'root'
})
export class SensorService {

  private baseUrl = 'http://localhost:8080/api/sensorData';

  constructor(private httpClient: HttpClient) {
  }

  getSensors(): Observable<Sensors> {
    return this.httpClient
      .get<Sensors>(this.baseUrl);
  }

  getNames(): Observable<string[]> {
    return this.httpClient
      .get<string[]>(this.baseUrl + "/names");
  }

  getSensorsByName(name : string) : Observable<Sensors> {
      return this.httpClient
    .get<Sensors>(this.baseUrl + "/getMostRecent4/" + name);
  }

}
