import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { User } from 'src/app/models/user.model';
import { AddressService } from 'src/app/services/address.service';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {

  addressStatus : boolean = false;
  user : User ;
  constructor(private cartService : CartService,private addressService : AddressService,private router : Router) {
    this.user = new User(0,"","","","");
    
  }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);


    this.cartService.fetchByUser(this.user.userId).then(data=>{
      localStorage.setItem("cart",JSON.stringify(data));
    })
    this.addressService.list(this.user.userId).then(data=>{
      if(data !== null){
        this.addressStatus = true;
      }
    })
  }

  redirect(){
    this.router.navigate(['addAddress']);
  }
}
