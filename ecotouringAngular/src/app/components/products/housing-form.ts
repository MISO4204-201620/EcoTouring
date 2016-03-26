import {Component,OnInit, Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm,CORE_DIRECTIVES, FORM_DIRECTIVES, NgClass, NgStyle}    from 'angular2/common';
//import {FileSelect, FileDrop, FileUploader} from 'ng2-file-upload';
import {Housing} from '../../models/product/housing.model'

declare var jQuery : any;

@Component({
  selector: 'housing-form',
  providers: [],
  templateUrl: 'templates/housing-form.html',
  styleUrls :[],
  directives: [NgClass, NgStyle, CORE_DIRECTIVES, FORM_DIRECTIVES],
  pipes: []
})

export class HousingFormComponent implements OnInit {

  elementRef : ElementRef;
	constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef){
		this.elementRef = elementRef;
	}
	

  model : Housing;
  submitted = false;

	ngOnInit(){ 
    this.model = new Housing (0,"",new Date(Date.now()),new Date(Date.now()),"",0,"","",0,0,""); 
    jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(){ this.submitted = true; }

}