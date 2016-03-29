import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {EcoTour} from '../../models/product/eco-tour.model';
import {EcoTourService} from '../../services/eco-tour.service';
import {User} from '../../models/user/user.model'

declare var jQuery : any;

@Component({
  selector: 'eco-tour-form',
  providers: [EcoTourService],
  templateUrl: 'templates/eco-tour-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class EcoTourFormComponent implements OnInit {
	
  elementRef : ElementRef;

  constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef, private _ecoTourService : EcoTourService){
		this.elementRef = elementRef;
	}

  model : EcoTour;
  userToken : User;
  submitted = false;
  createOk = false;
  okMessage :string;
  errorMessage : string;
	
	ngOnInit(){
    this.model = new EcoTour (); 
    jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(model : EcoTour){ 
  
    if (!model) {return;}

    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        let userToken = JSON.parse(objUser);
        
        model.supplier = {id : userToken.id};

        this._ecoTourService.createService(model)
                  .subscribe(
                    model => this.onEcoTourSuccesfull(model),
                    error => this.errorMessage = <any>error
                  );
    }

    this.submitted = true; 

  }

  onEcoTourSuccesfull (model : EcoTour){

    this.createOk = true;
    this.okMessage = "Servicio " + model.name + " fue creado exitosamente.";
  }

}