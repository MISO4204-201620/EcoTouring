import {Component,OnInit,Inject, ElementRef} from 'angular2/core';
import {Location, RouteParams,RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {Feeding} from '../../models/product/feeding.model';
import {FeedingService} from '../../services/feeding.service';
import {User} from '../../models/user/user.model'

declare var jQuery : any;

@Component({
  selector: 'feeding-form',
  providers: [FeedingService],
  templateUrl: 'templates/feeding-form.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class FeedingFormComponent implements OnInit {
	
  elementRef : ElementRef;

  constructor(params : RouteParams, private _router: Router, @Inject(ElementRef) elementRef : ElementRef, private _feedingService : FeedingService){
		this.elementRef = elementRef;
	}

  model : Feeding;
  userToken : User;
  submitted = false;
  createOk = false;
  okMessage :string;
  errorMessage : string;
	
	ngOnInit(){ 
    this.model = new Feeding (); 
    //jQuery(this.elementRef.nativeElement).find('.editor').wysihtml5();
  }

  onSubmit(model : Feeding){ 
  
    if (!model) {return;}

    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        let userToken = JSON.parse(objUser);
        
        model.supplier = {id : userToken.id};

        this._feedingService.createService(model)
                  .subscribe(
                    model => this.onFeedingSuccesfull(model),
                    error => this.errorMessage = <any>error
                  );
    }

    this.submitted = true; 

  }

  onFeedingSuccesfull (model : Feeding){

    this.createOk = true;
    this.okMessage = "Servicio " + model.name + " fue creado exitosamente.";
  }
}