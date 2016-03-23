import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {EcoTour} from '../../models/product/eco-tour.model'

declare var jQuery : any;

@Component({
  selector: 'eco-tour-form',
  providers: [],
  templateUrl: 'templates/eco-tour-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class EcoTourFormComponent implements OnInit {
	
  elementRef : ElementRef;

  constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef){
		this.elementRef = elementRef;
	}

  model : EcoTour;
  submitted = false;
	
	ngOnInit(){
    this.model = new EcoTour (); 
    jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(){ this.submitted = true; }

}