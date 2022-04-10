import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Order } from '../models/order.models';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private static url : string = "http://localhost:8880";
  ord:Order;
  orders:Order[]=[];
  list:Order[]=[];
  ordDate = Date.now();

  constructor(private http:HttpClient) { 
    this.ord= new Order('',0,this.ordDate,'',Address, User)
  }

  async getByUserId(uid: number){
    const order$= this.http.get<Order>(OrderService.url+"/get/${uid}");
    const res = await firstValueFrom(order$);
    return res;
  }

  async List(){   //Dummy to check the list of Ordersplaced
    const orders$= this.http.get<Order[]>(OrderService.url+"/list");
    orders$.subscribe(data=>{
      this.orders=data;
    });
    return await firstValueFrom(orders$);
  }
}
