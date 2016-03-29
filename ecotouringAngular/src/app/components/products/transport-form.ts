import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {Transport} from '../../models/product/transport.model';
import {TransportService} from '../../services/transport.service';
import {User} from '../../models/user/user.model'

declare var jQuery : any;

@Component({
  selector: 'transport-form',
  providers: [TransportService],
  templateUrl: 'templates/transport-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class TransportFormComponent implements OnInit {

  elementRef : ElementRef;
	constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef, private _transportService : TransportService){
		this.elementRef = elementRef;
	}
	
  model : Transport;
  userToken : User;
  submitted = false;
  createOk = false;
  okMessage :string;
  errorMessage : string;

	ngOnInit(){
    this.model = new Transport (); 
    jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(model : Transport){ 
  
    if (!model) {return;}

    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        let userToken = JSON.parse(objUser);
        
        model.supplier = {id : userToken.id};

        this._transportService.createService(model)
                  .subscribe(
                    model => this.onTransportSuccesfull(model),
                    error => this.errorMessage = <any>error
                  );
    }

    this.submitted = true; 

  }

  onTransportSuccesfull (model : Transport){

    this.createOk = true;
    this.okMessage = "Servicio " + model.name + " fue creado exitosamente.";
  }
}