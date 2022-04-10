import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
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
  constructor(private service: ProductService,private cartService : CartService) { }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
    this.service.List().then(data => {
      this.product = data;
    })
  }

  addToCart(idx : number){
    // new UserProduct(this.user.userId,this.product[idx].pid);
     this.cartService.addToCart(new UserProduct(this.user.userId,this.product[idx].pid));
     setTimeout(()=>{
       this.ngOnInit();
     },1000);
  }
}
