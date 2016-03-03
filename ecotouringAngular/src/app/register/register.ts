import {Component} from 'angular2/core';
import {Router} from 'angular2/router';

@Component({
  selector: 'register-app',
  providers: [],
  templateUrl: 'templates/signup.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class RegisterComponentApp {
  constructor(private _router: Router){}
}