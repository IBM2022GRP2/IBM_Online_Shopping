<<<<<<< HEAD
export class Product{
=======
import { ShoppingCart } from "./cart.model";
import { Order } from "./order.model";

export class Product{
    public prod_cart : ShoppingCart[] = [];
    public prod_ord : Order[] = [];
>>>>>>> 2faa68eadb41de14dd630a34eaff9a1c44e7520c
    constructor(
        public pid:number,
        public pname:string,
        public price:number,
        public stock:number,
        public category:string
    ){}
}