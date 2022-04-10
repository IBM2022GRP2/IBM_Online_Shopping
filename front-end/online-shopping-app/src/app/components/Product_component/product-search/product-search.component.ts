import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  product: Product[] = [];
  sname: string;
  scategory: string;
  namel: string[] = [];
  categoryl: string[] = [];
  f: string = '';
  highp: number = 0;
  lowp: number = 0;

  constructor(private service: ProductService) {
    this.sname = "";
    this.scategory = "";
    this.lowp = 0;
    this.service.List().then(data => { this.categoryl = [...new Set(data.map(x => x.category))] });
    this.service.List().then(data => { this.namel = [...new Set(data.map(x => x.pname))] });

  }

  ngOnInit(): void {

  }
  search() {
    if (this.categoryl.includes(this.f)) {
      this.service.findByCategory(this.f).then(data => {
        this.product = data;
      });
    }
    else {
      this.service.findByName(this.f).then(data => {
        this.product = data;
      });
    }
  }
  searchbyrange() {
    this.service.findByPriceRange(this.lowp, this.highp).then(data => {
      this.product = data;
    })

  }
}
