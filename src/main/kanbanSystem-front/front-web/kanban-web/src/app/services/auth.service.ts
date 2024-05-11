import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { tap } from "rxjs/operators";
import { AuthenticationResponse } from "../models/AuthResponse";
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private readonly URL: string = 'http://localhost:91';
  private readonly USER_ROLE_KEY = 'userRole';

  constructor(private http: HttpClient, private router : Router) { }

  authenticate(username: string, password: string) {
    return this.http.post<AuthenticationResponse>(`${this.URL}/authenticate`, { username: username, password: password })
      .pipe(tap(response => {
        sessionStorage.setItem(this.USER_ROLE_KEY, response.user.roles);
      }));
  }
  register(username: string, email: string, password: string): Observable<AuthenticationResponse> {
    return this.http.post<AuthenticationResponse>(`${this.URL}/register`, { username, email, password });
  }
  logout() {
    sessionStorage.clear();
    this.router.navigate(['/home']);
  }
  getUserRole(): string {
    return sessionStorage.getItem(this.USER_ROLE_KEY) || '';
  }
  
}
