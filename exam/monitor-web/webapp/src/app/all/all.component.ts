import { Component, OnInit } from '@angular/core';
import { Sensor } from '../models/sensor.model';
import { SensorService } from '../sensor.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {

  sensors : Sensor[];
  errorMessage : string;


  constructor(private sensorService : SensorService) { }

  ngOnInit(): void {
    this.getSensors();
  }

  getSensors() {
    this.sensorService.getSensors()
    .subscribe(
      sensors => this.sensors = sensors.sensorsData,
      error => this.errorMessage = <any>error
    );
  }

}
