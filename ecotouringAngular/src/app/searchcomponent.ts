import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES,Router,RouteParams} from 'angular2/router';

@Component({
  selector: 'search-index-app',
  providers: [],
  templateUrl: 'templates/search.html',
  styleUrls :['css/components/search.css'],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})
@RouteConfig([

])
export class SearchComponentApp {
  
}