import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  email: any;
  constructor(private service: UserService ,private router : Router) { 
  }

  ngOnInit(): void {

  }
  forgetpass(){
    this.service.forgotpassword(this.email);
    this.router.navigate(['afterforgot']);
  }

}

// this.service.loginUserFromRemote(this.login).then((data) => {
//   this.user = data;
//   this.isLoggedIn=true;
//   localStorage.setItem("loginStatus",JSON.stringify(this.isLoggedIn));
//   localStorage.setItem("regularUser", JSON.stringify(this.user));
//   setTimeout(()=>{
//     this.route.navigate(['loginsuccess']).then(()=>{
//       window.location.reload()}
//     )},1000);
// },
