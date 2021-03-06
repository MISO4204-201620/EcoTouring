import {Component,OnInit, Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm,CORE_DIRECTIVES, FORM_DIRECTIVES, NgClass, NgStyle}    from 'angular2/common';
import {Housing} from '../../models/product/housing.model';
import {HousingService} from '../../services/housing.service';
import {User} from '../../models/user/user.model'

declare var jQuery : any;

@Component({
  selector: 'housing-form',
  providers: [HousingService],
  templateUrl: 'templates/housing-form.html',
  styleUrls :[],
  directives: [NgClass, NgStyle, CORE_DIRECTIVES, FORM_DIRECTIVES],
  pipes: []
})

export class HousingFormComponent implements OnInit {

  elementRef : ElementRef;
	constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef, private _housingService : HousingService){
		this.elementRef = elementRef;
	}
	

  model : Housing;
  userToken : User;
  submitted = false;
  createOk = false;
  okMessage :string;
  errorMessage : string;

	ngOnInit(){ 
    this.model = new Housing (); 
    //jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(model : Housing){ 
    //alert(model.description);
    if (!model) {return;}

    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        let userToken = JSON.parse(objUser);
        
        model.supplier = {id : userToken.id};

        this._housingService.createService(model)
                  .subscribe(
                    model => this.onHousingSuccesfull(model),
                    error => this.errorMessage = <any>error
                  );
    }

    this.submitted = true; 

  }

  onHousingSuccesfull (model : Housing){

    this.createOk = true;
    this.okMessage = "Servicio " + model.name + " fue creado exitosamente.";
  }

}