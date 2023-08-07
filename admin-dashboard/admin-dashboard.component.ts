import { Component } from '@angular/core';
import { User } from 'src/user';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  users: User[] = []; // Initialize the users array
  unreadMessagesCount: number = 0; // Initialize the unreadMessagesCount
  showMessage: boolean = false; // Initialize the showMessage flag
  emergencyMode: boolean = false; // Initialize the emergencyMode flag

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit(): void {
    // Fetch the list of users when the component initializes
    this.getAllUsers();
  }

  getAllUsers() {
  
  }

  deleteUser() {

  }

  showMessageOverlay(): void {
    // Implement the logic to show the message overlay here
    // Set the showMessage flag to true to show the overlay
    this.showMessage = true;
  }

  closeMessageOverlay(): void {
    // Implement the logic to close the message overlay here
    // Set the showMessage flag to false to hide the overlay
    this.showMessage = false;
  }

  showMessages(): void {
    // Implement the logic to show messages when the notification icon is clicked
    // For example, you could fetch the unread messages from the server and update the unreadMessagesCount
    // For demonstration purposes, I'm just incrementing the count here
    this.unreadMessagesCount++;
  }

  onToggleChange(): void {
    // Implement the logic for the emergency toggle switch change event here
    // You can access the value of the emergencyMode using this.emergencyMode
    // For example, you could send a request to the server to update the emergency mode status
    // based on the value of this.emergencyMode
  }
}

