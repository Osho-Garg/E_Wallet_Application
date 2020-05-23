import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { SendMoney } from './models/SendMoney';
import { LoginModel } from './models/LoginModel';
import { UserDetails } from './models/UserDetails';
import { Recharge } from './models/Recharge';

@Injectable({
  providedIn: 'root'
})


export class WalletServicesService {

  private baseUrl = 'http://localhost:8085'
  constructor(private http: HttpClient) { }



  allDataFromProfile : any
  
  userLogin(login : LoginModel)
  {
    return this.http.post<any>(this.baseUrl + "/accounts/userLogin/"+login.userName+"/"+login.password,"")
    .pipe(catchError(this.errorHandler))
  }

  registerUser(data:UserDetails)
  {
    return this.http.post<any>(this.baseUrl + "/accounts/new",data)
    .pipe(catchError(this.errorHandler))
  }

  getAllTransactions(senderId: Number) {
    return this.http.get<any>(this.baseUrl + "/transaction/history/" + senderId)
    .pipe(catchError(this.errorHandler))
  }
  sendMoney(transferDetails) {
    return this.http.post<any>(this.baseUrl + "/transaction/transfer/",transferDetails)
    .pipe(catchError(this.errorHandler))
  }
  getProfile(id) {
    return this.http.get<any>(this.baseUrl + "/wallet/profile/"+id)
    .pipe(catchError(this.errorHandler))
  }

  

  recharge(data:Recharge)
  {
    console.log("i am in service and data is ",data)
    return this.http.post<any>(this.baseUrl + "/wallet/deposit",data)
    .pipe(catchError(this.errorHandler))
  }
  errorHandler(error: HttpErrorResponse) {
    return throwError(error)
  }


}
