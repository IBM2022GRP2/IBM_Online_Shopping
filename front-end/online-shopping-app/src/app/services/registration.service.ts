import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { User } from '../models/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http: HttpClient) { }
  public loginUserFromRemote(user : User): Observable<any>{
    return this._http.post<any>("http://localhost:8880/login",user);
  }

  public registerUserFromRemote(user: User){
    return this._http.post("http://localhost:8880/signup",user);
  }
}
