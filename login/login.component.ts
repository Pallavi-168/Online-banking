import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../../user';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 // username: string = '';
  //password: string = '';
  user: User=new User("","","","","","","","");
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (!this.user.username || !this.user.pass) {
      alert('Please enter both username and password to login.');
      return;
    }

    this.authService.loginUser(this.user).subscribe(
      (response: any) => {
        console.log('Login successful:', response);
        console.log("uId",response.id);
       localStorage.setItem('uname',this.user.username);
       localStorage.setItem('uId',response.id);
        this.router.navigate(['/user-dashboard']);
      },
      (error: any) => {
        console.error('Login failed:', error);
        if (error.status === 401) {
          this.errorMessage = 'Invalid username or password';
        } else {
          this.errorMessage = 'An unexpected error occurred. Please try again later.';
        }
      }
    );
  }
}
