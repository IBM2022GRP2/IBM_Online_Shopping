import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { Login } from 'src/app/models/login.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/registration.service';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  login : Login;
  isLoggedIn:Boolean=true;
  constructor(private service: UserService, private route: Router) {
    this.user = new User(0, "", "", "", "");
    this.login = new Login("","");
  }

  ngOnInit(): void {
  }

  loginUser() {

    this.service.loginUserFromRemote(this.login).then(data => {
      this.user = data;
      console.log("Data", data);
    });
    if(this.login.email == "admin" && this.login.pass == "admin"){
      this.route.navigate(['adminpanel']);
    }
    else if(this.user!=null){
      this.isLoggedIn=true;
      localStorage.setItem("loginStatus",JSON.stringify(this.isLoggedIn));
      localStorage.setItem("regularUser", JSON.stringify(this.user));
      console.log("Logged IN", this.user);
      this.route.navigate(['loginsuccess'])
    }else{
      this.isLoggedIn=false;
    }
  }

}
