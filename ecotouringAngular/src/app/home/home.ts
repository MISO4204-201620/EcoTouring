import {Component} from 'angular2/core';
import {Router,RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from 'angular2/router';
import {SearchComponentApp} from './../searchcomponent';
import {CategoriesPanelApp} from './../categoriespanel';
import {CounterApp} from './../counter';


@Component({
  selector: 'home-app',
  providers: [
  ],
  templateUrl: 'templates/home.html',
  directives: [SearchComponentApp,CategoriesPanelApp,CounterApp],
  pipes: []
})

export class HomeApp {
  constructor(private _router: Router){}
  
}
