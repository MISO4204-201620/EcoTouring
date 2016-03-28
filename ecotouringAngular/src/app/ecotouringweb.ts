import {Component} from 'angular2/core';
import {Route, Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {RegisterComponentApp} from './register/register';
import {CategoriesApp} from './categories/categories';
import {HomeApp} from './home/home';
import {ShoppingCartComponent} from './components/cart/shopping-cart';
import {ServiceFormComponent} from './components/products/service-form';
import {CategoryListService} from './services/category-list.service';
import {User} from './models/user/user.model'


@Component({
  selector: 'ecotouringweb-app',
  templateUrl: './templates/ecotouringweb.html',
  directives: [ROUTER_DIRECTIVES],
  providers: [
  ROUTER_PROVIDERS,
  HTTP_PROVIDERS,
  CategoryListService
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
  }
])
export class EcotouringwebApp {

  userToken : User;
  isLogged = false;
	constructor(public router: Router) {

    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        this.userToken = JSON.parse(objUser);
        this.isLogged = true;
    }else {
      this.userToken = new User;
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
