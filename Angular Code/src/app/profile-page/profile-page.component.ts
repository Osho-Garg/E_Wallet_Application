import { Component, OnInit } from '@angular/core';
import { WalletServicesService } from '../wallet-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  constructor(private walletService :WalletServicesService,
    private router : Router) { }
  allProfileData :any
  userName:any
  ngOnInit(): void {
    this.userName = localStorage.getItem("loggedInUserName")
   this.allProfileData = this.walletService.allDataFromProfile
  }

  logout()
  {
    localStorage.setItem("userLoggedInStatus","")
    localStorage.setItem("balance","")
    this.router.navigate(['/'])
  }

}
