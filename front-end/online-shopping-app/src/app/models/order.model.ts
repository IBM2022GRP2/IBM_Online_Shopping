import { Address } from "./address.model";
import { Product } from "./product.model";
import { User } from "./user.model";

export class Order{
    public product_list : Product[] = [];
    constructor(
        public oid : string,
        public totalprice : number,
        public status : string,
        public date : Date,
        public userord : User,
        public addOrd : Address
    ){}
}