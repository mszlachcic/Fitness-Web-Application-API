import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

export interface IUserDto {
  email: string;
  username: string;
  password: string;
  role: number
}

export interface IUserLoginDto {
  username: string,
  password: string
}

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) {

  }
  headers: HttpHeaders = new HttpHeaders()
    .set('Access-Control-Allow-Origin', '*');

  url = 'http://127.0.0.1:8080/users/';
  token = ""

  createUser(user: IUserDto): Observable<IUserDto> {
    return this.http.post<IUserDto>(`${this.url}createUser`, user);
  }

  login(loginDetails: IUserLoginDto) {
    return this.http.post<any>(`http://127.0.0.1:8080/login`, {
      username: loginDetails.username,
      password: loginDetails.password
    },
      { 'observe': 'response' });
  }
  getPublicContent(): Observable<any> {
    return this.http.get('127.0.0.1:8080/users/test', { responseType: 'text' });
  }
  getUserBoard(): Observable<any> {
    return this.http.get('127.0.0.1:8080/users/test', { responseType: 'text' });
  }

}

