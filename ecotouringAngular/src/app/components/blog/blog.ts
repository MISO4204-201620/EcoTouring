import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS,ROUTER_DIRECTIVES,RouteData} from 'angular2/router';
import {Blog} from './blog.model';
import {BlogService} from './blog.service';

@Component({
  selector: 'blog-ecotouring',
  providers: [BlogService],
  templateUrl: './app/components/blog/blog-list.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class BlogComponent implements OnInit {

	entries : Blog[];
	errorMessage : string;

	constructor(params : RouteParams, private _router: Router, private _blogService : BlogService){
		
	}

	ngOnInit(){ 
		this.getEntries();
	}

	getEntries(){
	  	this._blogService.getEntries()
				.subscribe(
					entries => this.entries = entries,
					error => this.errorMessage = <any>error
				);
  	}
}