import {Component,OnInit,Inject} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {User} from '../../models/user/user.model'

@Component({
  selector: 'user-profile-app',
  providers: [],
  templateUrl: 'templates/user-profile.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class ProfileComponentApp implements OnInit {
	
	constructor(params : RouteParams, private _router: Router){

	}

	user : User;
	isLogged = false;

	ngOnInit(){
		if(sessionStorage.getItem('userSession')){
			this.user = JSON.parse(sessionStorage.getItem('userSession'));
			this.isLogged = true;
		}
	}

	onLogOut(){
	    if(sessionStorage.getItem('userSession')){
	        sessionStorage.removeItem('userSession');
	        this.user = new User();
	        this.isLogged = false;
	        let link = ['Home'];
	        this._router.navigate(link);
	    } 
	  }
}