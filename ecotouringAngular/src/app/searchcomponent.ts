import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS,ROUTER_DIRECTIVES} from 'angular2/router';
import {ItemThumb} from './interfaces/item-thumb';
import {SearchItemsService} from './services/search-items.service';
import {EcotouringwebApp} from './ecotouringweb';

@Component({
  selector: 'search-index-app',
  providers: [SearchItemsService],
  templateUrl: 'templates/search.html',
  styleUrls :['css/components/search.css'],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class SearchComponentApp  {
	
	constructor(params : RouteParams, private _router: Router){
		
	}

	param : string;
	errorMessage : string;
	items : ItemThumb[];
	selectedItem: ItemThumb;
	searchDescription : string;

	onSearch(){
		let link = ['SearchResults', 'ItemsSearch', { text : this.searchDescription}];
		this._router.navigate(link);
	}

	onSelect(item : ItemThumb) {
		this.selectedItem = item;
	}
}