import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from 'src/app/models/User';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  person :User;
  name :String;

  constructor(
    private router :Router
  ) { }

  ngOnInit(): void {
    var data = localStorage.getItem('user');
    this.person = JSON.parse(data);
    this.name = this.person.firstName + " " + this.person.lastName;
  }

}
