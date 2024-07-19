import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  isLoggedIn(): boolean {
    return this.auth.isLoggedIn();
  }

  handleLogoutBtn(): void {
    this.auth.logoutUser();
    this.router.navigate(['/']);

  }

}
