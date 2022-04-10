import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShoppingCart } from 'src/app/models/cart.model';
import { Checkout } from 'src/app/models/pojos/checkout.model';
import { Items } from 'src/app/models/pojos/items.model';

import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  items : Items[] = [];
  cart : ShoppingCart;

  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  constructor(private cartService : CartService, private router:Router) { 
    this.cart = new ShoppingCart(0,0,this.user)
  }

  ngOnInit(): void {
    
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
    this.cartService.fetchByUser(this.user.userId).then(data=>{
      this.cart = data;
    })
    this.cart = JSON.parse(localStorage.getItem("cart")!);
    this.cartService.viewCart(this.cart.cartid).then(data=>{
      this.items = data;
    })
  }

  checkout(){
    var coup = JSON.parse(localStorage.getItem("coupon")!);
    var add = JSON.parse(localStorage.getItem("address")!);
    this.cartService.checkOut(new Checkout(coup,this.user.userId,add));

    this.cartService.fetchByUser(this.user.userId).then(data=>{
      this.cart = data;
      localStorage.setItem("cart",JSON.stringify(data));
      } );
      this.router.navigate(['order']);
    setTimeout(()=>{
      this.ngOnInit();},1000);
  }
}
