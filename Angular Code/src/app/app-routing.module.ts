import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WalletDashboardComponent } from './wallet-dashboard/wallet-dashboard.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { TransactionsComponent } from './transactions/transactions.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { RechargeWalletComponent } from './recharge-wallet/recharge-wallet.component';
import { TransferMoneyComponent } from './transfer-money/transfer-money.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [
  {path:"",component:UserLoginComponent},
  {path:'wallet-dashboard',component:WalletDashboardComponent,canActivate:[AuthGuard]},
  {path:'profile',component:ProfilePageComponent,canActivate:[AuthGuard]},
  {path:'transactions',component:TransactionsComponent,canActivate:[AuthGuard]},
  {path:'user/recharge-wallet',component:RechargeWalletComponent,canActivate:[AuthGuard]},
  {path:'user/money-transfer',component:TransferMoneyComponent,canActivate:[AuthGuard]},
  {path:'user-registration',component:UserRegistrationComponent},
  {path:'**',component:PageNotFoundComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
