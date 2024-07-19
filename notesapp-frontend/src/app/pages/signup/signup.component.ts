import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiResponse } from 'src/app/models/api-response';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  username: string = "";
  fname: string = "";
  lname: string = "";
  password: string = "";
  confirmPass: string = "";
  registerFailed: boolean = false;
  message: string = "";

  constructor(private userService: UserService, private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.auth.isLoggedIn()){
      this.router.navigate(['/notes']);
    }

  }

  registerUser(form: NgForm){
    if(form.valid && this.validatePassword()){
      this.userService.createUser(form.value).subscribe((res: ApiResponse) => {
        if(res.success){
          this.message ="";
          this.loginUser({username:form.value.username, password:form.value.password});
        }
        else{
          this.message = res.message;
        }
      })
    }
    else{
      Object.values(form.controls).forEach(control => {
        control.markAsTouched();
      });
    }
  }

  loginUser(credentials: {username: string, password: string}): void{
    this.auth.authenticateUser(credentials).subscribe((res: ApiResponse) => {
      if(res.success){
        this.message = "";
        localStorage.setItem("token", res.data.token);
        this.router.navigate(['/notes'])
      }
    })
  }

  validatePassword(){
    return this.password === this.confirmPass;
  }

}
