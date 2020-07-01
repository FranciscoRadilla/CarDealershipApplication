import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../../services/user/user.service'
import { InfoService } from '../../services/field/info.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username :string;
  password :string;

  result :string;
  invalid :boolean = false;

  constructor(
    private router :Router,
    private user :UserService,
    private field :InfoService
  ) { }

  ngOnInit(): void {
  }

  LogIn() {
    //console.log("Username " + this.username);
    //console.log("Password " + this.password);

    if(this.valid()) {

      this.user.LogIn(this.username, this.password).subscribe(
        (resp) => {
          var person = resp;
          //console.log(person);

          if(person.firstName == 'Person does not exist') {
            this.invalid = true;
            this.result = "User does not exist!";
          } else if (person.firstName == 'Password does not match') {
            this.invalid = true;
            this.result = "Password does not match";
          } else {
            localStorage.setItem('user',JSON.stringify(person));
            this.field.login = true;

            if(person.isEmployee == 1) {
              //This is a employee
              this.router.navigate(['/employee']);
              this.field.ChangeLog();
            } else {
              //This is a customer
              this.router.navigate(['/customer']);
              this.field.ChangeLog();
            }
          }
        },
        (resp) => {
          console.log("Problems occured")
          this.invalid = true;
          this.result = "Problems occured";
        }
      );
    } else {
      this.invalid = true;
      this.result = "Must fill out the feilds!";
    }
  }

  valid() :boolean {
    if(this.username == undefined || this.username == "" ||
      this.password == undefined || this.password == "") {
      return false;
    } else {
      return true;
    }
  }

}
