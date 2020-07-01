import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  show :boolean = true;
  info :string = "Update";
  person :User;

  firstName :string;
  lastName :string;
  userName :string;
  email :string;
  address :string;

  invalid :boolean = false;
  result :string;

  constructor(
    private router :Router,
    private user :UserService
  ) { }

  ngOnInit(): void {
    var data = localStorage.getItem('user');
    this.person = JSON.parse(data);
  }

  Change() {
    this.show = !this.show;

    if(this.info == "Update") {
      this.info = "Profile";
      this.firstName = this.person.firstName;
      this.lastName = this.person.lastName;
      this.userName = this.person.userName;
      this.email = this.person.email;
      this.address = this.person.address;
    } else {
      this.info = "Update";
    }
  }

  Submit() {

    if(this.valid()) {
      var update = new User(this.person.userId, this.firstName, this.lastName, this.userName, this.person.password, 
        this.person.isEmployee, this.address, this.email);
      
      this.user.UpdateUser(update).subscribe(
        (resp) => {
          console.log(resp);
          localStorage.clear();
          localStorage.setItem('user',JSON.stringify(resp));
          this.result = "Update Successful!";
          this.invalid = true;
          this.person = update;
        },
        (resp) => {
          this.result = "Problems Occured!";
        }
      );    
    }

  }

  valid() :boolean {
    if(
      this.firstName == undefined ||
      this.lastName == undefined || 
      this.userName == undefined || 
      this.email == undefined || 
      this.address == undefined 
    ) {
      this.result = "Fields are undefined!"
      this.invalid = true;
      return false;
    } else {
      this.invalid = false;
      return true;
    }

  }

}
