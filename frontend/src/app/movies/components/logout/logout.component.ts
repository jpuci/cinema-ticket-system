import { Component } from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'ts-logout',
  template: `
    <h2>Logout</h2>
    <button (click)="logout()">Logout</button>
  `
})
export class LogoutComponent {
  constructor(private authService: AuthService) {}

  logout(): void {
    this.authService.logout().subscribe(
      (response: any)  => {
        // Handle successful logout
        console.log('Logged out successfully');
      },
      (error: any) => {
        // Handle logout error
        console.error('Logout failed');
      }
    );
  }
}
