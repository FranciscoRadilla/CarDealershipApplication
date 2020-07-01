import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { InfoService } from '../../services/field/info.service'
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  person :User;

  constructor(
    private router :Router,
    public field :InfoService
  ) { }

  ngOnInit(): void {
  }

  Log() {
    if(!this.field.boolcreate) {
      this.field.ChangeBoolCreate();
    }

    if(this.field.loginoff == "Log In") {
      if(this.field.boollog) {
        this.router.navigate(['/login']);
        this.field.ChangeBoolLog();
      } else {
        this.router.navigate(['/']);
        this.field.ChangeBoolLog();
      }
    } else {
      this.router.navigate(['/']);
      this.field.loginoff = "Log In";
      this.field.login = false;
      this.field.ChangeBoolLog();
      localStorage.clear();
    }

  }

  Create() {
    if(!this.field.boollog) {
      this.field.ChangeBoolLog();
    }

    if(this.field.boolcreate) {
      this.router.navigate(['/createuser']);
      this.field.ChangeBoolCreate();
    } else {
      this.router.navigate(['/']);
      this.field.ChangeBoolCreate();
    }
  }

  Profile() {
    var data = localStorage.getItem('user');
    this.person = JSON.parse(data);

    if(this.field.boolprofile) {
      this.router.navigate(['/profile']);
      this.field.ChangeBoolProfile();
    } else {
      console.log(this.person.isEmployee);
      if(this.person.isEmployee == 1) {
        this.router.navigate(['/employee']);
      } else {
        this.router.navigate(['/customer']);
      }
      this.field.ChangeBoolProfile();
    }
  }

  ViewCars() {
    var data = localStorage.getItem('user');
    this.person = JSON.parse(data);

    if(this.field.boolview) {
      this.router.navigate(['/viewcars']);
      this.field.ChangeBoolView();
    } else {
      if(this.person.isEmployee == 1) {
        this.router.navigate(['/employee']);
      } else {
        this.router.navigate(['/customer']);
      }
      this.field.ChangeBoolView();
    }
  }

}
