import { Component, OnInit } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { WalletServicesService } from '../wallet-services.service';
import { SendMoney } from '../models/SendMoney';

@Component({
  selector: 'app-wallet-dashboard',
  templateUrl: './wallet-dashboard.component.html',
  styleUrls: ['./wallet-dashboard.component.css']
})
export class WalletDashboardComponent implements OnInit {

  constructor(private router: Router, private walletServices: WalletServicesService) { }

  userName: any
  allData: any
  fivedata : any = []
  totalAmount: any
  ngOnInit(): void {
    this.userName = localStorage.getItem("loggedInUserName")
    this.walletServices.getProfile(Number(localStorage.getItem("userId")))
      .subscribe(
        data => {
          if (data != null) {
            this.walletServices.allDataFromProfile = data
            this.totalAmount = data.wallet.balance
            localStorage.setItem("balance",data.wallet.balance)
            this.walletServices.getAllTransactions(Number(localStorage.getItem("accountId")))
              .subscribe(
                data2 => {
                  if (data2 != null) {
                    this.allData = data2
                    let i=0
                    let five = 5
                    if(this.allData.length <= 5)
                    {
                      this.fivedata = this.allData
                    }
                   
                    
                  }
                },
                error => {
                  console.log("These is a error", error)
                }
              )
          }
        },
        error => {
          console.log("These is a error", error)
        }
      )
  }
  logout()
  {
    localStorage.setItem("userLoggedInStatus","")
    localStorage.setItem("balance","")
    this.router.navigate(['/'])
  }

}
