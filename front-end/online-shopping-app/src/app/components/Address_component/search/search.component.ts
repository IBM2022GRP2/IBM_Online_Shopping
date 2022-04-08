import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/address.model';
import { UserAddress } from 'src/app/models/user.address.model';
import { AddressService } from 'src/app/services/address.service';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  address : Address[]=[];
  uid : number;

  constructor(private service: AddressService) {
    this.uid = 0;
    
  }

  ngOnInit(): void {
    
  }
  
  list(){
    console.log(this.uid);
    this.service.list(this.uid).then(data => {
      this.address = data;
    })
  }

}