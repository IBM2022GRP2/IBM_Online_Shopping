import { Component, OnInit } from '@angular/core';

import { ProductService } from '../../services/product.service';
import { Product } from '../../models/product.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
product:Product[]=[];
  constructor(private service:ProductService) { }

  ngOnInit(): void {
    this.service.List().then(data=>{
      this.product = data;
    });
  }
  
}
