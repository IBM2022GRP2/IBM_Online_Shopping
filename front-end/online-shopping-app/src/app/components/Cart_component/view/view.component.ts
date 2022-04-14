import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { ShoppingCart } from 'src/app/models/cart.model';
import { Coupon } from 'src/app/models/coupon.model';
import { Checkout } from 'src/app/models/pojos/checkout.model';
import { Items } from 'src/app/models/pojos/items.model';

import { User } from 'src/app/models/user.model';
import { AddressService } from 'src/app/services/address.service';
import { CartService } from 'src/app/services/cart.service';
import { CouponService } from 'src/app/services/coupon.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  items : Items[] = [];
  cart : ShoppingCart;
  addresses : Address[]=[];
  coupons : Coupon[]=[];
  // address : Address;

  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  constructor(private cartService : CartService, private router:Router , private addressService : AddressService , private couponService : CouponService) { 
    this.cart = new ShoppingCart(0,0,this.user)
  
  }

  ngOnInit(): void {
    
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
    this.addressService.list(this.user.userId).then(data=>{
      this.addresses = data;
    });
    this.couponService.fetchAll().then(data =>{
      this.coupons = data;
    });
    this.cartService.fetchByUser(this.user.userId).then(data=>{
      this.cart = data;
    })
    this.cart = JSON.parse(localStorage.getItem("cart")!);
    this.cartService.viewCart(this.cart.cartid).then(data=>{
      this.items = data;
    })
  }

  selectAddress(idx : number){
      console.log(this.addresses[idx]);
  }

  checkout(){
    var coup = JSON.parse(localStorage.getItem("coupon")!);
    var add = JSON.parse(localStorage.getItem("address")!);
    this.cartService.checkOut(new Checkout(coup,this.user.userId,add));

    this.cartService.fetchByUser(this.user.userId).then(data=>{
      this.cart = data;
      localStorage.setItem("cart",JSON.stringify(data));
      setTimeout(()=>{
        // this.ngOnInit();
        this.router.navigate(['checkout']);
      },1000);
      } );
  }
}
