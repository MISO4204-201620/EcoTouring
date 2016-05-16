import {Component, OnInit, Inject, ElementRef} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS,ROUTER_DIRECTIVES,RouteData} from 'angular2/router';
import {NgForm,CORE_DIRECTIVES, FORM_DIRECTIVES, NgClass, NgStyle}    from 'angular2/common';
import {Blog} from './blog.model';
import {BlogService} from './blog.service';
import {User} from '../../models/user/user.model'

@Component({
  selector: 'entry-ecotouring',
  providers: [BlogService],
  templateUrl: './app/components/blog/create-entry.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES, NgClass, NgStyle, CORE_DIRECTIVES, FORM_DIRECTIVES],
  pipes: []
})

export class EntryComponent implements OnInit {

	elementRef : ElementRef;
	entry : Blog;
	userToken : User;
	submitted = false;
	createOk = false;
	okMessage :string;
	errorMessage : string;
	user : User;

	constructor(params : RouteParams, private _router: Router, private _blogService : BlogService, @Inject(ElementRef) elementRef : ElementRef){
		this.elementRef = elementRef;
	}

	ngOnInit(){ 
		this.entry = new Blog (); 
		this.user = JSON.parse(sessionStorage.getItem('userSession'));
		this.entry.author = this.user;
		this.entry.date = new Date(Date.now());
	}

	onSubmit(entry : Blog){ 

		if (!entry) {return;}

		if(sessionStorage.getItem('userSession')){
	    	let objUser = sessionStorage.getItem('userSession');
	    	let userToken = JSON.parse(objUser);
	    
	    	this._blogService.createEntry(entry)
	              .subscribe(
	                entry => this.onEntrySuccesfull(entry),
	                error => this.errorMessage = <any>error
	              );
		}

		this.submitted = true; 

	}

	onEntrySuccesfull (entry : Blog){

		this.createOk = true;
		this.okMessage = "La entrada " + entry.title + " fue creada exitosamente.";
		this.entry = entry;
	}
}