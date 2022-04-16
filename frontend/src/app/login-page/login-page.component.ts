import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/token-storage.service';
@Component({
  selector: 'app-login',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  userName = '';
  constructor(private authService: AuthService, private tokenStorage: TokenStorageService) { }
  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;
    this.authService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.userName = this.tokenStorage.getUser().username;
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  reloadPage(): void {
    window.location.reload();
  }
}
//   onSubmit(): void {
//     const { username, password } = this.form;
//     this.authService.login(username, password).subscribe(
//       data => {
//         this.tokenStorage.saveToken(String(data.headers.get('Authorization')));
//         this.tokenStorage.saveUser(data);
//         this.isLoginFailed = false;
//         this.isLoggedIn = true;
//         this.roles = this.tokenStorage.getUser().roles;
//         this.reloadPage();
//       },
//       err => {
//         this.errorMessage = err.error.message;
//         this.isLoginFailed = true;
//       }
//     );
//   }
//   reloadPage(): void {
//     window.location.reload();
//   }
// }

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////

// import { Component, OnInit } from '@angular/core';
// import { CookieService } from 'ngx-cookie-service';
// import { UserService } from '../service/user.service';

// @Component({
//   selector: 'app-login-page',
//   templateUrl: './login-page.component.html',
//   styleUrls: ['./login-page.component.scss']
// })
// export class LoginPageComponent implements OnInit {

//   constructor(private userService: UserService, private cookieService: CookieService) { }
//   ngOnInit() {
//     sessionStorage.setItem('token', '');
//   }

//   logIn() {
//       let username = (<HTMLInputElement>document.getElementById("username")).value;
//       let password = (<HTMLInputElement>document.getElementById("password")).value;

//       let loginDetails = {
//         username,
//         password
//       }
//     this.userService
//       .login(loginDetails)
//       .subscribe(res => {
//         let value: string;
//         value = String(res.headers.get('Authorization'))
//         console.log(value)
//         this.cookieService.set('token', value)
//       }
//       )
//   }

// }