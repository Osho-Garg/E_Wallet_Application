import { Component, OnInit } from '@angular/core';
import { UserDetails } from '../models/UserDetails';
import { WalletServicesService } from '../wallet-services.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  constructor(private walletServices : WalletServicesService,
    private router :Router) { }

  userDetailsModel = new UserDetails("","","","");
  ngOnInit(): void {
    
  }

  register()
  {

    this.walletServices.registerUser(this.userDetailsModel)
    .subscribe(
      data=>{
        if(data)
        {
          alert("You are successfully registered !")
          this.router.navigate(['/'])
        }
      },
      error=>{
        alert("Username already exists")
      }
    )

  }

}
