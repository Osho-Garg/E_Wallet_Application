import { Component, OnInit } from '@angular/core';
import { WalletServicesService } from '../wallet-services.service';
import { Router } from '@angular/router';
import { LoginModel } from '../models/LoginModel';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  constructor(private walletServices : WalletServicesService,
    private router : Router) { }

  userLoginModel = new LoginModel("","")

  notification:any

  clicked() {

    this.walletServices.userLogin(this.userLoginModel)
      .subscribe(
        data => {
          if (data.status) {

           
            localStorage.setItem("userId",JSON.stringify(data.userId))  
            localStorage.setItem("accountId",JSON.stringify(data.accountId))
            localStorage.setItem("loggedInUserName",JSON.stringify(data.name))
            localStorage.setItem("userLoggedInStatus",data.status)
            
            this.router.navigate(['wallet-dashboard'])
          }
          else {
            this.notification = 'password';
          }
        },
        error => {
          if (error.status === 500) {
            this.notification = 'login'
          }
        }
      )
  }
  ngOnInit(): void {
  }

}
