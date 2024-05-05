import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerModule } from './customer/customer.module';
import { LoginModule } from './login/login.module';
import { RestaurantAdminModule } from './restaurant-admin/restaurant-admin.module';
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';


@NgModule({
  declarations: [AppComponent, HomeComponent, WelcomeComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CustomerModule,
    LoginModule,
    RestaurantAdminModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
