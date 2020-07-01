import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from 'src/app/models/User';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  person :User;
  name :string;

  constructor(
    private router :Router
  ) { }

  ngOnInit(): void {
    var data = localStorage.getItem('user');
    this.person = JSON.parse(data);
    this.name = this.person.firstName + " " + this.person.lastName;
  }

  Profile() {
    this.router.navigate(['/profile'])
  }

}
