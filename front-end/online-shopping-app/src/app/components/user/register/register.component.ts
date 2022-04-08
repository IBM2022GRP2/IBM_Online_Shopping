import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;
  constructor(private service : RegistrationService, private _router : Router) {
    this.user = new User(0, "", "", "", "");
  }

  ngOnInit(): void {
  }
  registerUser(){
    this.service.registerUserFromRemote(this.user);
    this._router.navigate(['/login']); 
  }

}
