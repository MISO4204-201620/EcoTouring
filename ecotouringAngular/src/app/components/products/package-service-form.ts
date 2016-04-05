import {Component,OnInit, Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm,CORE_DIRECTIVES, FORM_DIRECTIVES, NgClass, NgStyle}    from 'angular2/common';
//import {FileSelect, FileDrop, FileUploader} from 'ng2-file-upload';
import {Package} from '../../models/product/package.model';
import {PackageService} from '../../services/package-service.service';
import {User} from '../../models/user/user.model'

@Component({
  selector: 'package-form',
  providers: [PackageService],
  templateUrl: 'templates/package-form.html',
  styleUrls :[],
  directives: [NgClass, NgStyle, CORE_DIRECTIVES, FORM_DIRECTIVES],
  pipes: []
})

export class PackageFormComponent implements OnInit {
	
	elementRef : ElementRef;
	constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef, private _packageService : PackageService){
		this.elementRef = elementRef;
	}

	model : Package;
	userToken : User;
	submitted = false;
	createOk = false;
	okMessage :string;
	errorMessage : string;

	ngOnInit(){ 
		this.model = new Package (); 
		//jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
	}

	onSubmit(model : Package){ 
		alert(model.description);
		if (!model) {return;}

		if(sessionStorage.getItem('userSession')){
	    	let objUser = sessionStorage.getItem('userSession');
	    	let userToken = JSON.parse(objUser);
	    
	    	model.supplier = {id : userToken.id};

	    	this._packageService.createService(model)
	              .subscribe(
	                model => this.onPackageSuccesfull(model),
	                error => this.errorMessage = <any>error
	              );
		}

		this.submitted = true; 

	}

	onPackageSuccesfull (model : Package){

	this.createOk = true;
	this.okMessage = "Servicio " + model.name + " fue creado exitosamente.";
	}
}