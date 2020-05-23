import { Component, OnInit } from '@angular/core';
import { Recharge } from '../models/Recharge';
import { WalletServicesService } from '../wallet-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recharge-wallet',
  templateUrl: './recharge-wallet.component.html',
  styleUrls: ['./recharge-wallet.component.css']
})
export class RechargeWalletComponent implements OnInit {

  constructor(private walletService : WalletServicesService,
    private router : Router ) { }

  amount : any
  totalAmount:any
  rechargeModel = new Recharge(0,0)
  userName:any
  ngOnInit(): void {
    this.userName = localStorage.getItem("loggedInUserName")
    this.totalAmount = this.walletService.allDataFromProfile.wallet.balance
  }
  recharge(){
    this.rechargeModel.accountId = Number(localStorage.getItem("accountId"))
    this.rechargeModel.balance = this.amount
    this.walletService.recharge(this.rechargeModel)
    .subscribe(
      data=>{
        if(data!=null)
        {
          
          this.router.navigate(['wallet-dashboard'])
        }
      },
      error=>{
        console.log("There is an error")
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
