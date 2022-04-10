import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  user : User ;
  constructor() {
    this.user = new User(0,"","","","");
  }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
  }

}
