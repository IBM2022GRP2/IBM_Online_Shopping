import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProduct } from 'src/app/models/pojos/user.product.model';
import { Product } from 'src/app/models/product.model';
import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListProductComponent implements OnInit {
  product: Product[] = [];
  user : User = new User(0,"","","","");
  loginStatus : boolean = false;
  constructor(private service: ProductService,private cartService : CartService,private router : Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
    this.loginStatus = JSON.parse(localStorage.getItem("loginStatus")!)
    this.service.List().then(data => {
      this.product = data;
    })
  }

  addToCart(idx : number){
    
     this.cartService.addToCart(new UserProduct(this.user.userId,this.product[idx].pid));
     setTimeout(()=>{
       this.ngOnInit();
     },1000);

  }
}
