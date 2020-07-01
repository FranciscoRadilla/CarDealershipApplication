import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { CustomerComponent } from './components/customer/customer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateuserComponent } from './components/createuser/createuser.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ViewcarsComponent } from './components/viewcars/viewcars.component';

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path:'employee', component: EmployeeComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'navbar', component: NavbarComponent},
  {path: 'createuser', component: CreateuserComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'viewcars', component: ViewcarsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
