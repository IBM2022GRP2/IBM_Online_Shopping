import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  message : String = "";
  constructor() {  
   }

  ngOnInit(): void {
    this.message = JSON.parse(localStorage.getItem("order")!);
  }
  }
