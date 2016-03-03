import {View,Component} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {RegisterComponentApp} from './register/register';
import {HomeApp} from './home/home';

let template = './templates/ecotouringweb.html';

@Component({
  selector: 'ecotouringweb-app',
  templateUrl: template,
  directives: [ROUTER_DIRECTIVES],
  providers: [
  ROUTER_PROVIDERS
  ],
  pipes: []
})
@RouteConfig([
  { 
    path: '/', 
    name: 'Home',
    component: HomeApp, 
    useAsDefault: true 
  },
  { 
    path: '/signup', 
    component: RegisterComponentApp,
    name: 'Signup' 
  }
  //{ path: '/login', component: Login, as: 'Login' },
  //{ path: '/signup', component: Signup, as: 'Signup' }
])
export class EcotouringwebApp {

	constructor(public router: Router) {
  	}
  defaultMeaning: number = 42;
  
  meaningOfLife(meaning?: number) {
    return `The meaning of life is ${meaning || this.defaultMeaning}`;
  }
}
