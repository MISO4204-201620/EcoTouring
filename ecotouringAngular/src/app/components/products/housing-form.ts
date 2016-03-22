import {Component,OnInit} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';

@Component({
  selector: 'housing-form',
  providers: [],
  templateUrl: 'templates/housing-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class HousingFormComponent implements OnInit {
	constructor(params : RouteParams, private _router: Router){
		
	}
	
	ngOnInit(){ }

}