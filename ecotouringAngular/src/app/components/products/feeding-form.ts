import {Component,OnInit} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';

@Component({
  selector: 'feeding-form',
  providers: [],
  templateUrl: 'templates/feeding-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class FeedingFormComponent implements OnInit {
	constructor(params : RouteParams, private _router: Router){
		
	}
	
	ngOnInit(){ }

}