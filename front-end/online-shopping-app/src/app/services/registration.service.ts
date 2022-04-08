import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { User } from '../models/user.model';
import { firstValueFrom, Observable } from 'rxjs';
import { Login } from '../models/login.model';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  private static url : string = "http://localhost:8880/User";
  constructor(private _http: HttpClient) { }

  async loginUserFromRemote(login : Login){
    const user$ = this._http.post<User>(RegistrationService.url+"/login",login);
    const res = await firstValueFrom(user$);
    return res;

  }

  async registerUserFromRemote(user: User){
    const user$ = this._http.post(RegistrationService.url+"/signup",user);
    return await firstValueFrom(user$);
  }
}
