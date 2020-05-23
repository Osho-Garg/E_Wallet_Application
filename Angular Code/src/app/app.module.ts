import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WalletDashboardComponent } from './wallet-dashboard/wallet-dashboard.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { HttpClientModule }    from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { TransferMoneyComponent } from './transfer-money/transfer-money.component';
import { RechargeWalletComponent } from './recharge-wallet/recharge-wallet.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


@NgModule({
  declarations: [
    AppComponent,
    WalletDashboardComponent,
    TransactionsComponent,
    ProfilePageComponent,
    UserLoginComponent,
    UserRegistrationComponent,
    TransferMoneyComponent,
    RechargeWalletComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
