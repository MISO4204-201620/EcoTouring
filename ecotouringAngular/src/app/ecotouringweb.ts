import {Component} from 'angular2/core';
import {Route, Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {RegisterComponentApp} from './register/register';
import {CategoriesApp} from './categories/categories';
import {HomeApp} from './home/home';
import {ShoppingCartComponent} from './components/cart/shopping-cart';
import {ServiceFormComponent} from './components/products/service-form';
import {PayloadComponent} from './components/cart/payload-cart';
import {ProfileComponentApp} from './components/user/profile';
import {CreateUsersComponentApp} from './components/user/create-users';
import {UserListService} from './services/users-list.service';
import {CategoryListService} from './services/category-list.service';
import {User} from './models/user/user.model';

@Component({
  selector: 'ecotouringweb-app',
  templateUrl: './templates/ecotouringweb.html',
  directives: [ROUTER_DIRECTIVES],
  providers: [
  ROUTER_PROVIDERS,
  HTTP_PROVIDERS,
  CategoryListService,
  UserListService
  ],
  pipes: []
})
@RouteConfig([
  { 
    path: '/', 
    name: 'Home',
    component: HomeApp
  },
  { 
    path: '/signup', 
    component: RegisterComponentApp,
    name: 'Signup' 
  },
  { 
    path: '/categories/...', 
    component: CategoriesApp,
    name: 'Categories' 
  },
  {
    path: '/shopping-cart',
    component: ShoppingCartComponent,
    name: 'ShoppingCart'
  },
  {
    path: '/create-service/...',
    component: ServiceFormComponent,
    name: 'ServiceForm'
  },
  {
    path: '/payload',
    component: PayloadComponent,
    name: 'PayloadCart'
  },
  {
    path: '/results/...',
    component: CategoriesApp,
    name: 'SearchResults'
  },
  {
    path: '/profile', 
    component: ProfileComponentApp,
    name: 'Profile'
  },
  { 
    path: '/create-user', 
    component: CreateUsersComponentApp,
    name: 'CreateUserForm' 
  }
])
export class EcotouringwebApp {

  userToken : User;
  isLogged = false;
  _router : Router;
	constructor(public router: Router, private _userListService : UserListService) {

    this._router = router;
    this.login = new User (); 

    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        this.userToken = JSON.parse(objUser);
        this.isLogged = true;
    }else {
      this.userToken = new User;
    }
  }

  login : User;
  users : User[];
  errorMessageLogin : string;
  okMessageLogin :string;
  loginOk = false;
  userLogged = null;

  onLogin( user : User){ 
    if (!user) {return;}

    this.login = user;

    this._userListService.getUsers()
                  .subscribe(
                    users => this.loginValidator(users),
                    error => this.errorMessageLogin = <any>error
                  );
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
      this.router.navigate(link);

    }else {
      alert(errorMessageLogin);
    }
  }


  defaultMeaning: number = 42;
  
  meaningOfLife(meaning?: number) {
    return `The meaning of life is ${meaning || this.defaultMeaning}`;
  }

  onLogOut(){
    if(sessionStorage.getItem('userSession')){
        sessionStorage.removeItem('userSession');
        this.userToken = new User();
        this.isLogged = false;
        let link = ['Home'];
        this.router.navigate(link);
    } 
  }
}
