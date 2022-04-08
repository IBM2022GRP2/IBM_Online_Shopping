export class Address {
    constructor(
        public addressId : number,
        public houseNo : number,
        public street : string,
        public city : string,
        public state : string,
        public pincode : number,
    ){}
}