import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {User} from '../models/user/user.model'

@Component({
  selector: 'register-app',
  providers: [],
  templateUrl: 'templates/signup.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class RegisterComponentApp implements OnInit {
  constructor(params : RouteParams, private _router: Router){}

  register : User;
  login : User;
  submitted = false;

	ngOnInit(){
    this.register = new User (); 
    this.login = new User (); 
  }

  onRegister(){ this.submitted = true; }

  onLogin(){ this.submitted = true; }
}