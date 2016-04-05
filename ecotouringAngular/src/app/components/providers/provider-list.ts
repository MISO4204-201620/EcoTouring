import {Component, OnInit} from 'angular2/core';
import {Router} from 'angular2/router';
import {Provider} from '../../interfaces/provider';
import {ProviderListService} from '../../services/provider-list.service';

@Component({
  selector: 'provider-list',
  providers: [],
  templateUrl: 'templates/provider-list.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class ProviderListComponent implements OnInit {
  constructor(private _router: Router, private _providerListService : ProviderListService){}

  errorMessage : string;
  providers : Provider[];
  selectedProvider: Provider;

  ngOnInit(){ this.getProviders();}

  getProviders(){
  	this._providerListService.getProviders()
  								.subscribe(
  									providers => this.providers = providers,
  									error => this.errorMessage = <any>error
  								);
  }

  onSelect(provider : Provider) {
  	this.selectedProvider = provider;
    console.log(provider);
  }

  onFilter(){
    let link = ['ItemsSupplier',{supplier : this.selectedProvider.id}];
    this._router.navigate(link);
    console.log(this.selectedProvider.id);
  }
}