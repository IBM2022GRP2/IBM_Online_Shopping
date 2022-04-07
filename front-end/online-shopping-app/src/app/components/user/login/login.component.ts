import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { RegistrationService } from 'src/app/services/registration.service';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  constructor(private service: RegistrationService, private route: Router) {
    this.user = new User(0, "", "", "", "");
  }

  ngOnInit(): void {
  }
  loginUser() {
    // this.service.loginUserFromRemote(this.user).subscribe(
    //   data => { 
    //     console.log("response received");

    //   },

    //   error => console.log("exception occured")
    // );
    this.service.loginUserFromRemote(this.user).subscribe(data => {
      this.user = data;
      console.log("Response Received")
      this.route.navigate(['/loginsuccess']);
    });
  }

}
