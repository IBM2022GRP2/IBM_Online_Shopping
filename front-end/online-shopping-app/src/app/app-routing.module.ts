import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';
import { ListComponent } from './components/Product_component/list/list.component';
import { RegisterComponent } from './components/user/register/register.component';
import { LoginsuccessComponent } from './components/user/loginsuccess/loginsuccess.component';
import { SearchComponent } from './components/Address_component/search/search.component';
import { ProductSearchComponent } from './components/Product_component/product-search/product-search.component';

const routes: Routes = [
  {path:'login',component : LoginComponent},
  {path:'loginsuccess',component: LoginsuccessComponent},
  {path:'register',component : RegisterComponent},
  {path:'list',component: ListComponent},
  {path : '',component:RegisterComponent},
  { path: 'search' , component:ProductSearchComponent }

  // [address path]
  // {path:'',redirectTo:'/add',pathMatch:'full'},
  // {path:'add',component:AddComponent},
  // {path:'list',component:ListComponent},
  // {path:'search',component:SearchComponent},
  // {path:'**',redirectTo:'/add',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
