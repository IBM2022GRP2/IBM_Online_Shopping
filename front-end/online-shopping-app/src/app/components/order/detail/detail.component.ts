import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/models/order.model';
import { Items } from 'src/app/models/pojos/items.model';
import { User } from 'src/app/models/user.model';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  item:Items[]=[];
  order: Order=JSON.parse(localStorage.getItem("orderitem")!);
  user : User = JSON.parse(localStorage.getItem("regularUser")!);

  constructor(private service:OrderService) { }

  ngOnInit(): void {
    this.service.viewProducts(this.order.oid).then(data=>{
      this.item = data;
    })
  }

}
