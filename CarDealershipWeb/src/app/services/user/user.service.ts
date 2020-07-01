import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url :string;

  constructor(private http: HttpClient) { 
    this.url = "http://localhost:8080/user"
  }

  private headers = new HttpHeaders({'content-type' : 'application/json'});

  //add
  CreateCustomer(user: User) :Observable<User> {
    return this.http.post<User>(this.url, user, {headers: this.headers});
  }

  //get user by id
  GetaCustomer(userId :number): Observable<User> {
    return this.http.get<User>(this.url + "/" + userId);
  }

  //get all users
  GetAllCustomers(): Observable<User[]> {
    return this.http.get<User[]>(this.url);
  }

  //update
  UpdateUser(user :User): Observable<User> {
    return this.http.put<User>(this.url, user, {headers: this.headers});
  }

  //delete

  //Login
  LogIn(username :string, password :string): Observable<User> {
    return this.http.get<User>(this.url + "/" + username + "/" + password);
  }
}
