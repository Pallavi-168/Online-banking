import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'; 
import { User } from '../user';
import { tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private loginUrl = 'http://localhost:8086/api/user';
  private loggedInUser: User | null = null;



  constructor(private http: HttpClient) {}

  loginUser(user: User): Observable<any> {
    console.log('Sending login request with credentials:', user);
    return this.http.post(`${this.loginUrl}/login`, user).pipe(
      tap((response: any) => {
        // Assuming the response contains the user object with firstName and lastName
        this.storeLoggedInUser(response.user);
      })
    );
  }

public registerUser(user:User){
  return this.http.post(`${this.loginUrl}`, user);
}
storeLoggedInUser(user: User) {
  this.loggedInUser = user;
}

// Get the stored logged-in user
getLoggedInUser(): User | null {
  return this.loggedInUser;
}

}
