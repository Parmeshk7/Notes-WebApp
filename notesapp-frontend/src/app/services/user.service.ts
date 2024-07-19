import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/api-response';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private createUserAPI = "http://localhost:8081/auth/create-user"; 

  constructor(private http: HttpClient) { }

  createUser(userData: User): Observable<ApiResponse> {
    return this.http.post<ApiResponse>(this.createUserAPI, userData);
  }

  
}
