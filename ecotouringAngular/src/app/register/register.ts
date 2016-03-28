import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {User} from '../models/user/user.model'
import {RegisterService} from '../services/register.service';
import {UserListService} from '../services/users-list.service';
import {EcotouringwebApp} from '../ecotouringweb';

@Component({
  selector: 'register-app',
  providers: [RegisterService, UserListService],
  templateUrl: 'templates/signup.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class RegisterComponentApp implements OnInit {
  constructor(params : RouteParams, private _router: Router, private _registerService : RegisterService, private _userListService : UserListService){}

  register : User;
  login : User;
  submitted = false;
  errorMessage : string;
  registerOk = false;
  okMessage :string;
  users : User[];
  errorMessageLogin : string;
  okMessageLogin :string;
  loginOk = false;
  userLogged = null;

	ngOnInit(){
    this.register = new User (); 
    this.login = new User (); 
  }

  onRegister( user : User){
    if (!user) {return;}

    this._registerService.createUser(user)
                  .subscribe(
                    user => this.onUserSuccesfull(user),
                    error => this.errorMessage = <any>error
                  );

    this.submitted = true; 
  }

  onUserSuccesfull (user : User){

    this.registerOk = true;
    this.okMessage = "Usuario " + user.fullName + " fue creado exitosamente.";
    this.register = new User;
  }

  onLogin( user : User){ 
    if (!user) {return;}

    this.login = user;

    this._userListService.getUsers()
                  .subscribe(
                    users => this.loginValidator(users),
                    error => this.errorMessage = <any>error
                  );
    this.submitted = true; 

  }

  loginValidator (users :User[]) {
    this.users = users;
    let userLogged : User;
    let loginOk = false;
    let errorMessageLogin = "";
    let email = this.login.email;
    let password = this.login.password;
    users.forEach(function (user){
        if (user.email === email){
          if(user.password === password) {
            userLogged = user;
            loginOk = true;
          }else {
            errorMessageLogin = "Password incorrecto";            
          }
        }else {

          errorMessageLogin = "Email incorrecto o usuario no existe. ";
        }
    });

    if(loginOk) {
      
      this.userLogged = userLogged;

      if(typeof(Storage) !== "undefined"){
      
        if(sessionStorage.getItem('userSession')){
          sessionStorage.removeItem('userSession');
        }else {
          sessionStorage.setItem('userSession', JSON.stringify(this.userLogged));
        }
      }else {
        alert("Favor actualizar su explorador !");
      }
      alert("Login exitoso");
      let link = ['Home'];
      let ecoRoot = new EcotouringwebApp(this._router);
      ecoRoot.router.navigate(link);

    }else {
      alert(errorMessageLogin);
    }
  }
}