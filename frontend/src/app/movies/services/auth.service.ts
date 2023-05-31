import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {map, Observable} from 'rxjs';
import jwtDecode, { JwtPayload } from 'jwt-decode';
import {CookieService} from 'ngx-cookie-service';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient, private cookieService: CookieService) {
  }

  login(credentials: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, credentials)
      .pipe(
        map((response) => {
          // Extract the token from the response
          const token = response.token;

          // Store the token in the localStorage
          localStorage.setItem('jwtToken', token);

          return response;
        })
      );
  }

  logout(): Observable<any> {
    localStorage.removeItem('jwtToken')
    return this.http.post<any>(`${this.baseUrl}/logout`, {});
  }

  getToken(): string {
    return localStorage.getItem('jwtToken') || ""
  }

  isAuthenticated(): boolean {
    const token = this.getToken();
    if (token) {
      const decodedToken: any = jwtDecode(token); // Decode the token
      const expirationDate = new Date(decodedToken.exp * 1000); // Convert the expiration date to milliseconds
      const currentDate = new Date();

      return expirationDate > currentDate; // Check if the token is not expired
    }

    return false; // Return false if the token is not found
  }

}
