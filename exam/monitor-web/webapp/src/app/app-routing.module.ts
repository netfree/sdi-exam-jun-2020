import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllComponent } from './all/all.component';
import { SensorsComponent } from './sensors/sensors.component';


const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'all', component: AllComponent},
  {path: 'sensors', component: SensorsComponent}
  //{path: 'student/detail/:id', component: StudentDetailComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
