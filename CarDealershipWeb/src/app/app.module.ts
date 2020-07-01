import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { EmployeeComponent } from './components/employee/employee.component';

import { ApplicationService } from './services/application/application.service';
import { UserService } from  './services/user/user.service';
import { VehicleService } from './services/vehicle/vehicle.service';

import { HttpClientModule } from '@angular/common/http';
import { CustomerComponent } from './components/customer/customer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CreateuserComponent } from './components/createuser/createuser.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ViewcarsComponent } from './components/viewcars/viewcars.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    CustomerComponent,
    NavbarComponent,
    CreateuserComponent,
    ProfileComponent,
    ViewcarsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ApplicationService, 
    UserService, 
    VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
