import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private static url : string = "http://localhost:8880";
  prd:Product;
 products : Product[] = [];
  list:Product[]=[];
  constructor(private http:HttpClient) {
    this.prd=new Product(0,'',0,0,'')
   }
  addProduct(product:Product){
    this.http.post(ProductService.url+"/add",product).subscribe(data=>{data=product;});
  }
  async getProductBy(pid : number){
    const product$ = this.http.get<Product>(ProductService.url+`/fetch/${pid}`);
    const res = await firstValueFrom(product$);
    return res;
  }
  async List(){
    const products$= this.http.get<Product[]>(ProductService.url+"/list");
    products$.subscribe(data=>{
      this.products=data;
    });
    return await firstValueFrom(products$);
    // return this.http.get<Stock[]>(StockService.uri+"/getlist");
  }
  del(pid:number){
    return this.http.delete(ProductService.url+"/del/"+pid).subscribe();
  }
  findByCategory(category:string){
    return this.http.get<Product[]>(ProductService.url+"/byCategory?category="+category);
  }
  findByName(name:string){
    return this.http.get<Product[]>(ProductService.url+"/byName?name="+name);
  }
  
  findByPriceRange(lowp:number,highp:number){
    return this.http.get<Product[]>(ProductService.url+"/byPriceRange?lowp="+lowp+"&highp="+highp);
  }


}
