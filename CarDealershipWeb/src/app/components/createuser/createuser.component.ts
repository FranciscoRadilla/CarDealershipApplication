import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css']
})
export class CreateuserComponent implements OnInit {

  firstName :string;
  lastName :string;
  userName :string;
  email :string;
  address :string;
  password :string;
  verpass :string;

  invalid :boolean = false;
  result :string;

  constructor(
    private router :Router,
    private user :UserService
  ) { }

  ngOnInit(): void {
  }

  Submit() {

    if(this.valid()) {
      var person = new User(0, this.firstName, this.lastName, this.userName, this.password, 0,
        this.address, this.email);

      this.user.CreateCustomer(person).subscribe(
        (resp) => {
          //console.log(resp);
          this.router.navigate(['/']);
        },
        (resp) => {
          this.result = "Problems occured!";
        }
      );
    } 

  }

  valid() :boolean {
    if(
      this.firstName == undefined || this.firstName == "" ||
      this.lastName == undefined || this.lastName == "" ||
      this.userName == undefined || this.userName == "" ||
      this.email == undefined || this.email == "" ||
      this.address == undefined || this.address == "" ||
      this.password == undefined || this.password == "" ||
      this.verpass == undefined || this.verpass == "" 
    ) {
      this.result = "Must fill out all fields!"
      this.invalid = true;
      return false;
    } else if(this.password != this.verpass) {
      this.result = "Password and Verify Password do not match!";
      this.invalid = true;
      return false;
    } else {
      this.invalid = false;
      return true;
    }

  }

}
