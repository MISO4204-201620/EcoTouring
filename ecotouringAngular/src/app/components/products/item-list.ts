import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS,ROUTER_DIRECTIVES,RouteData} from 'angular2/router';
import {ItemThumb} from '../../interfaces/item-thumb';
import {ItemListService} from '../../services/item-list.service';
import {SearchItemsService} from '../../services/search-items.service';
import {ProviderItemsService} from '../../services/provider-items.service';
import {CategoriesApp} from '../../categories/categories';

@Component({
  selector: 'item-list',
  providers: [ItemListService,SearchItemsService,ProviderItemsService],
  templateUrl: 'templates/item-list.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class ItemListComponent implements OnInit {
	constructor(params : RouteParams, data: RouteData, private _router: Router, private _itemListService : ItemListService, private _searchItemService : SearchItemsService, private _providerItemsService : ProviderItemsService){
		
		if (data.get('search') !== null){
			this.dataSearch = params.get('text');
		} else if (data.get('supplier') !== null) {
			this.dataSupplier = params.get('supplier');
		} else {
			this.category = params.get('category');
		}
	}

	category : string;
	errorMessage : string;
	items : ItemThumb[];
	selectedItem: ItemThumb;
	dataSearch : string;
	dataSupplier : string;

	ngOnInit(){ 
		
		if(this.dataSearch !== undefined){
			this.getItemsSearch(this.dataSearch);
		} else if (this.dataSupplier !== undefined){
			this.getItemsSuppliers(this.dataSupplier);
		} else{
			this.getItems(this.category);
		}
		
	}

	getItemsSuppliers(idSupplier : string){
		this._providerItemsService.getItems(idSupplier)
									.subscribe(
										items => this.items = items,
										error => this.errorMessage = <any>error
									);
	}

	getItemsSearch(description : string){
		this._searchItemService.getItems(description)
									.subscribe(
										items => this.items = items,
										error => this.errorMessage = <any>error
									);
	}

	getItems(category : string){
		this._itemListService.getItems(category)
									.subscribe(
										items => this.items = items,
										error => this.errorMessage = <any>error
									);
	}

	onSelect(item : ItemThumb) {
		this.selectedItem = item;
	}
	
}