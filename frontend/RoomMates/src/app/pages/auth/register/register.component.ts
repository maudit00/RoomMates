import { Component, ViewChild } from '@angular/core';
import { NgForm, NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { IRegister } from '../../../models/i-register';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  constructor(private authSvc: AuthService, private route: Router) {}
  @ViewChild('f', { static: true })
  form!: NgForm;
  confirmPassword: string = '';

  regex: RegExp = /^[\w-.]+@([\w-]+.)+[\w-]{2,4}$/;

  isEmail(input: NgModel): boolean {
    return this.regex.test(input.value);
  }

  send() {
    let user: IRegister = {
      username:this.form.value.username,
      email: this.form.value.email,
      password: this.form.value.password,
    };

    this.authSvc.register(user).subscribe((res) => {
      console.log(res);
      this.form.reset();
      this.route.navigate(['/']);
    });
  }

  comparePasswords(): boolean {
    return this.confirmPassword === this.form.value.password;
  }

}
