import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [SignUpComponent, SignInComponent],
  imports: [
    CommonModule, ReactiveFormsModule, HttpClientModule
  ],
  exports:[SignUpComponent, SignInComponent]
})
export class LoginModule { }
