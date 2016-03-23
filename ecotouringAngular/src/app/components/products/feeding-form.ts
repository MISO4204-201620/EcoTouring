import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {Feeding} from '../../models/product/feeding.model'

declare var jQuery : any;

@Component({
  selector: 'feeding-form',
  providers: [],
  templateUrl: 'templates/feeding-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class FeedingFormComponent implements OnInit {
	
  elementRef : ElementRef;

  constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef){
		this.elementRef = elementRef;
	}

  model : Feeding;
  submitted = false;
	
	ngOnInit(){ 
    this.model = new Feeding (); 
    jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(){ this.submitted = true; }
}