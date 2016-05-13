import {Component, OnInit} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {NgForm}    from 'angular2/common';
import {HousingFormComponent} from './housing-form';
import {TransportFormComponent} from './transport-form';
import {FeedingFormComponent} from './feeding-form';
import {EcoTourFormComponent} from './eco-tour-form';
import {PackageFormComponent} from './package-service-form';

@Component({
  selector: 'service-form',
  templateUrl: 'templates/service-form.html',
  directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
  { 
    path: '/', 
    name: 'HousginForm',
    component: HousingFormComponent,
    useAsDefault : true
  },
  { 
    path: '/housing', 
    name: 'HousginForm',
    component: HousingFormComponent
  },
  { 
    path: '/transport', 
    name: 'TransportForm',
    component: TransportFormComponent
  },
  { 
    path: '/feeding', 
    name: 'FeedingForm',
    component: FeedingFormComponent
  },
  { 
    path: '/eco-tour', 
    name: 'EcoTourForm',
    component: EcoTourFormComponent
  }
])

export class ServiceFormComponent implements OnInit {
  
  constructor(private _router: Router){}

  model = '';
  submitted = false;
  activeForm : number;
  ngOnInit(){ this.activeForm = 1;}

  onSubmit() { this.submitted = true; }
  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }

  onSelect(item : number) {
  	this.activeForm = item;
  	let linkRoute : Array<string>;
  	switch (item){
  		case 1: 
  			linkRoute = ['HousginForm'];
  			break;
  		case 2: 
  			linkRoute = ['TransportForm'];
  			break;
  		case 3: 
  			linkRoute = ['FeedingForm'];
  			break;
  		case 4: 
  			linkRoute = ['EcoTourForm'];
  			break;
      case 5: 
        linkRoute = ['PackageServiceForm'];
        break;
  	}

  	this._router.navigate(linkRoute);
  }
}