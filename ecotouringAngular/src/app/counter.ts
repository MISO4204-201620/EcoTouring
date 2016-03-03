import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';

@Component({
  selector: 'counter-app',
  providers: [],
  templateUrl: 'templates/counter.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})
@RouteConfig([

])
export class CounterApp {
  
}