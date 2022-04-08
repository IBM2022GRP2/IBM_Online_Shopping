import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { UserAddress } from 'src/app/models/user.address.model';
import { AddressService } from 'src/app/services/address.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  address : UserAddress;
  state : string[];
  
  constructor(private service : AddressService,private router : Router) { 
    this.address = new UserAddress(0,0,0,'','','',0);
    this.state =  ["Andhra Pradesh","Goa","West Bengal","Bihar","Kerala"];
   
  }

  ngOnInit(): void {
  }

  add(){
    this.service.add(this.address);
    this.router.navigate(['/list']);
  }

}
