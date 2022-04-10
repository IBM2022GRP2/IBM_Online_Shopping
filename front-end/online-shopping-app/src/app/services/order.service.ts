import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Order } from '../models/order.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private static url : string = "http://localhost:8880/Order";

  constructor(private http:HttpClient) { }

  async getByUserId(uid: number){
    const order$= this.http.get<Order[]>(OrderService.url+"/get/"+uid);
    return await firstValueFrom(order$);
  }
}
