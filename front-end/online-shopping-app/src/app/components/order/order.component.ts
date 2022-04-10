import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order.model';
import { User } from 'src/app/models/user.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'orders-user',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  order:Order[]=[];
  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  
  constructor(private service:OrderService) { 
  }

  ngOnInit(): void {
    this.service.getByUserId(this.user.userId).then(data=>{
      this.order = data;
    })
  }

}
