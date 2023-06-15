import {Component} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'ts-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username = '';
  password = '';
  succesfullLogin = true;

  constructor(
    private authService: AuthService,
    private readonly router: Router
  ) {
  }

  login(): void {
    const credentials = {username: this.username, password: this.password};
    this.authService.login(credentials).subscribe(
      response => {
        // Handle successful login
        console.log('Logged in successfully');
        this.succesfullLogin = true;
        this.router.navigateByUrl(`/check-tickets`);
      },
      error => {
        // Handle login error
        console.error('Login failed');
        this.succesfullLogin = false;
        this.authService.logout();
      }
    );
  }

}
