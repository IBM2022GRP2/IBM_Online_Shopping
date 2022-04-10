import { Component, OnInit } from '@angular/core';
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
  checkOutStatus : boolean = false;
  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  constructor(private cartService : CartService) { 
    this.cart = new ShoppingCart(0,0,this.user)
  }

  ngOnInit(): void {
    this.checkOutStatus = JSON.parse(localStorage.getItem("checkout")!)
    if(this.checkOutStatus){
      this.cartService.fetchByUser(this.user.userId).then(data=>{
        console.log(data);
        localStorage.setItem("cart",JSON.stringify(data));
        this.checkOutStatus = true;
        localStorage.setItem("checkout",JSON.stringify(this.checkOutStatus));
      })

        this.cart = JSON.parse(localStorage.getItem("cart")!);
    }else{
      this.cart = JSON.parse(localStorage.getItem("cart")!);
    }
    this.cartService.viewCart(this.cart.cartid).then(data=>{
      this.items = data;
    })
  }

  checkout(){
    var coup = JSON.parse(localStorage.getItem("coupon")!);
    var add = JSON.parse(localStorage.getItem("address")!);
    console.log(coup,this.user.userId,add)
    this.cartService.checkOut(new Checkout(coup,this.user.userId,add));
    this.cartService.fetchByUser(this.user.userId).then(data=>{
      console.log(data);
      localStorage.setItem("cart",JSON.stringify(data));
      this.checkOutStatus = true;
      localStorage.setItem("checkout",JSON.stringify(this.checkOutStatus));
      setTimeout(()=>{
        this.ngOnInit();},1000);
    })
  }
}
