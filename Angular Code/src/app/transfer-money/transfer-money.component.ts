import { Component, OnInit } from '@angular/core';
import { WalletServicesService } from '../wallet-services.service';
import { Router } from '@angular/router';
import { SendMoney } from '../models/SendMoney';

@Component({
  selector: 'app-transfer-money',
  templateUrl: './transfer-money.component.html',
  styleUrls: ['./transfer-money.component.css']
})
export class TransferMoneyComponent implements OnInit {

  constructor(private walletServices :WalletServicesService,
    private router :Router) { }

  receiverAccId : any
  amount : any
  moneyTransfer = new SendMoney(0,0,0)
  userName:any
  totalAmount:any
  ngOnInit(): void {
    this.userName = localStorage.getItem("loggedInUserName")
    this.totalAmount = this.walletServices.allDataFromProfile.wallet.balance
  }
  sendMoney() {
    this.moneyTransfer.amount = this.amount
    this.moneyTransfer.receiverAccId = this.receiverAccId
    this.moneyTransfer.senderAccId = Number(localStorage.getItem("accountId"))
    this.walletServices.sendMoney(this.moneyTransfer)
      .subscribe(
        res => {
          if (res) {
          
            this.router.navigate(['wallet-dashboard'])
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
