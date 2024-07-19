import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiResponse } from 'src/app/models/api-response';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message:string = "";

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.auth.isLoggedIn()){
      this.router.navigate(['/notes']);
    }
  }

  handleLoginForm(loginData: NgForm){
    if(loginData.valid){
      this.auth.authenticateUser(loginData.value).subscribe((res:ApiResponse) => {
        if(res.success){
          this.message = "";
          localStorage.setItem("token", res.data.token);
          this.router.navigate(['/notes']);
        }
        else{
          this.message = res.message;
        }
      })
      
    }
    else{
      Object.values(loginData.controls).forEach(control => {
        control.markAsTouched();
      });
    }
  }

  
}
