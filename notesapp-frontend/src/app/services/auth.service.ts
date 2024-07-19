import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/api-response';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginAPI: string = "http://localhost:8081/auth/login";

  constructor(private http: HttpClient) { }

  authenticateUser(credentials: {username:string, password:string}): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.loginAPI, credentials);
  }

  isLoggedIn(): boolean{
    return !!localStorage.getItem("token");
  }

  logoutUser(): void {
    localStorage.removeItem("token");
  }


}
