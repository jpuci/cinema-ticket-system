import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'ts-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  constructor(private authService: AuthService) {
    this.authService = authService;
  }

  ngOnInit(): void {
  }

  isAuthenticated() :boolean {
    return this.authService.isAuthenticated();
}
  logout() {
      this.authService.logout()
  }
}
