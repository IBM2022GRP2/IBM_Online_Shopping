import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order.models';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  order:Order[]=[];
    
  constructor(private service:OrderService) { }

  ngOnInit(): void {
    this.service.List();
  }

}
