import { Component, OnInit } from '@angular/core';
import { HashTable } from '../models/hashtable.model';
import { Sensor } from '../models/sensor.model';
import { SensorService } from '../sensor.service';

@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})



export class SensorsComponent implements OnInit {

  sensorNames : string[];
  errorMessage : string;
  showFlag  : boolean;
  sensors: HashTable<Sensor[]> = {};


  constructor(private sensorService : SensorService) { }

  ngOnInit(): void {
    this.getNames();
  }

  getNames() {
    this.sensorService.getNames()
    .subscribe(
      names => this.sensorNames = names,
      error => this.errorMessage = <any>error
    );
  }

  getSensorsByName(name : string) {
    this.sensorService.getSensorsByName(name)
    .subscribe(
      names => this.sensors[name] = names.sensorsData,
      error => this.errorMessage = <any>error
    );
  }


  show() {
    for(let name of this.sensorNames){
      this.getSensorsByName(name);
    }
  }

}
