import { DatePipe, DATE_PIPE_DEFAULT_TIMEZONE } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { ShoppingCart } from 'src/app/models/cart.model';
import { Order } from 'src/app/models/order.model';
import { Items } from 'src/app/models/pojos/items.model';
import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  message : String = "";
  date : DatePipe = new DatePipe('en-US');
  order : Order;
  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  add : Address = JSON.parse(localStorage.getItem("deliveryAddress")!);
  constructor(private orderService : OrderService) {  
   this.order = new Order("",0,"",this.date,this.user,this.add);
  }

  ngOnInit(): void {
    this.message = JSON.parse(localStorage.getItem("order")!);
    this.orderService.getOrder(this.message).then(data=>{
      this.order = data;
    });
  }
}
