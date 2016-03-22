import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS,ROUTER_DIRECTIVES} from 'angular2/router';
import {ItemThumb} from '../../interfaces/item-thumb';
import {ItemListService} from '../../services/item-list.service';
import {CategoriesApp} from '../../categories/categories';

@Component({
  selector: 'item-list',
  providers: [ItemListService],
  templateUrl: 'templates/item-list.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class ItemListComponent implements OnInit {
	constructor(params : RouteParams, private _router: Router, private _itemListService : ItemListService){
		this.category = params.get('category');
	}
	category : string;
	errorMessage : string;
	items : ItemThumb[];
	selectedItem: ItemThumb;

	ngOnInit(){ this.getItems();}

	getItems(){
		this._itemListService.getItems()
									.subscribe(
										items => this.items = items,
										error => this.errorMessage = <any>error
									);
	}

	onSelect(item : ItemThumb) {
	this.selectedItem = item;
	}
	
}