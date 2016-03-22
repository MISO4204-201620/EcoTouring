import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS} from 'angular2/router';
import {ItemThumb} from '../../interfaces/item-thumb';

@Component({
  selector: 'shopping-cart',
  providers: [],
  templateUrl: 'templates/shopping-cart.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class ShoppingCartComponent implements OnInit {
	constructor(params : RouteParams, private _router: Router){
		
	}
	
	errorMessage : string;
	itemsBucket : ItemThumb[];
	selectedItem: ItemThumb;

	ngOnInit(){ }

	getItems(){
		
	}

	onSelect(item : ItemThumb) {
		this.selectedItem = item;
	}
	
}