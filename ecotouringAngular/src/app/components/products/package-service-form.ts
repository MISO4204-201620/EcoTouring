import {Component,OnInit, Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS,RouteData} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm,CORE_DIRECTIVES, FORM_DIRECTIVES, NgClass, NgStyle}    from 'angular2/common';
import {ItemThumb} from '../../interfaces/item-thumb';
import {Package} from '../../models/product/package.model';
import {PackageService} from '../../services/package-service.service';
import {ProviderItemsService} from '../../services/provider-items.service';
import {User} from '../../models/user/user.model'

@Component({
  selector: 'package-form',
  providers: [PackageService,ProviderItemsService],
  templateUrl: 'templates/package-form.html',
  styleUrls :[],
  directives: [NgClass, NgStyle, CORE_DIRECTIVES, FORM_DIRECTIVES],
  pipes: []
})

export class PackageFormComponent implements OnInit {
	
	elementRef : ElementRef;
	constructor(data: RouteData, params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef, private _packageService : PackageService,private _providerItemsService : ProviderItemsService){
		this.elementRef = elementRef;
	}

	model : Package;
	userToken : User;
	submitted = false;
	createOk = false;
	okMessage :string;
	errorMessage : string;
	dataSupplier : string;
	items : ItemThumb[];
	user : User;

	ngOnInit(){ 
		this.model = new Package (); 
		this.user = JSON.parse(sessionStorage.getItem('userSession'));
		this.getItemsSuppliers(String(this.user.id));
		//jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
	}

	onSubmit(model : Package){ 

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
		this.okMessage = "El paquete " + model.name + " fue creado exitosamente.";
		this.model = model;
	}

	getItemsSuppliers(idSupplier : string){
		this._providerItemsService.getItems(idSupplier)
									.subscribe(
										items => this.items = items,
										error => this.errorMessage = <any>error
									);
	}

	addItemToPackage (idPackage : number, idItem : number) {
		this._packageService.addItemPackage(idPackage,idItem)
	              .subscribe(
	                resp => this.addPackageSuccesfull(),
	                error => this.errorMessage = <any>error
	              );
	}

	addPackageSuccesfull () {
		alert("Producto adicionado al paquete");
	}
}