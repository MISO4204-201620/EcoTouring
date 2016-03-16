import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from 'angular2/router';
import {SearchComponentApp} from './searchcomponent';
import {CategoriesPanelApp} from './categoriespanel';


@Component({
  selector: 'home-app',
  providers: [
  	ROUTER_PROVIDERS
  ],
  templateUrl: 'templates/home.html',
  directives: [ROUTER_DIRECTIVES,SearchComponentApp],
  pipes: []
})
@RouteConfig([
	{
		
	}
])
export class HomeApp {
  
}
