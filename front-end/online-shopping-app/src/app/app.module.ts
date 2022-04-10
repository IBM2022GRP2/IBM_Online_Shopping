import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './components/Product_component/list/list.component';
import { RegisterComponent } from './components/user/register/register.component';
import { LoginComponent } from './components/user/login/login.component';
import { LoginsuccessComponent } from './components/user/loginsuccess/loginsuccess.component';
import { AddComponent } from './components/Address_component/add/add.component';
import { SearchComponent } from './components/Address_component/search/search.component';
import { ProductSearchComponent } from './components/Product_component/product-search/product-search.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminpanelComponent } from './components/user/adminpanel/adminpanel.component';


@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    RegisterComponent,
    LoginComponent,
    LoginsuccessComponent,
    AddComponent,
    SearchComponent,
    ProductSearchComponent,
    AdminpanelComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
