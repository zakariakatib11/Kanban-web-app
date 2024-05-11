import { Component } from '@angular/core';
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { LoginService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  authToken!: string;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private authService: LoginService, private router: Router) { }

  onLoginSubmit(form: NgForm) {
    this.authService.authenticate(form.value.username, form.value.password).subscribe(response => {
      if (response) {
        this.successMessage = "Logged in successfully!";
        this.errorMessage = '';
        console.log("correct");
        this.router.navigate(['/boards']);
      }
    }, error => {
      this.errorMessage = "";
      this.successMessage = '';
      alert("Username or password incorrect. Please try again.")
    });
    form.reset();
  }

  onSignupSubmit(form: NgForm) {
    this.authService.register(form.value.username, form.value.email, form.value.password).subscribe(response => {
      if (response) {
        alert("Your account has been created successfully.")
        this.router.navigate(['/home']);
      }
    }, error => {
      alert("Username or password incorrect. Please try again.")
    });
    form.reset();
  }
}
