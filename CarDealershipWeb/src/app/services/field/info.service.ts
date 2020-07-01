import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  loginoff :string = "Log In";
  boollog :boolean = true;
  boolcreate :boolean = true;
  boolprofile :boolean = true;
  boolview :boolean = true;

  login :boolean = false;

  constructor() { }

  ChangeLog() {
    if(this.loginoff == "Log In") {
      this.loginoff = "Log Off";
    } else {
      this.loginoff = "Log In";
    }
  }

  ChangeBoolLog() {
    this.boollog = !this.boollog
  }

  ChangeBoolCreate() {
    this.boolcreate = !this.boolcreate;
  }

  ChangeBoolProfile() {
    this.boolprofile = !this.boolprofile;
  }

  ChangeBoolView() {
    this.boolview = !this.boolview;
  }
}
