import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AllComponent } from './all/all.component';
import { SensorsComponent } from './sensors/sensors.component';

import { HttpClientModule } from '@angular/common/http';
import { SensorService } from './sensor.service';

@NgModule({
  declarations: [
    AppComponent,
    AllComponent,
    SensorsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [SensorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
