import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {User} from '../../models/user/user.model'
import {RegisterService} from '../../services/register.service';
import {EcotouringwebApp} from '../../ecotouringweb';

@Component({
  selector: 'create-users-app',
  providers: [RegisterService],
  templateUrl: 'templates/create-user.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class CreateUsersComponentApp implements OnInit {

	constructor(params : RouteParams, private _router: Router, private _registerService : RegisterService){}


	register : User;
	submitted = false;
	errorMessage : string;
	registerOk = false;
	okMessage :string;
	okMessageLogin :string;

	ngOnInit(){
	    this.register = new User (); 
  	}

  	onCreate( user : User){
	    if (!user) {return;}

	    user.role = "SUPPLIER";
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
}
