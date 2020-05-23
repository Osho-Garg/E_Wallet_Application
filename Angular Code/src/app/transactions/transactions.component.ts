import { Component, OnInit } from '@angular/core';
import { WalletServicesService } from '../wallet-services.service';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {

  constructor(private walletServices : WalletServicesService,
    private router :Router) { }

  userName:any
  allData : any
  totalAmount:any
  ngOnInit(): void {
    this.totalAmount = localStorage.getItem("balance")
    this.userName = localStorage.getItem("loggedInUserName")
    this.walletServices.getAllTransactions(Number(localStorage.getItem("accountId")))
    .subscribe(
      data=>{
        if(data!=null)
        {
          
          this.allData = data
          
        }
      },
      error=>{
        console.log("These is a error",error)
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
