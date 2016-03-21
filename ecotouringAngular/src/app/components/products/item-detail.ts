import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS} from 'angular2/router';
import {Item} from '../../interfaces/item';
import {ItemDetailService} from '../../services/item-detail.service';

@Component({
  selector: 'item-detail',
  providers: [ItemDetailService],
  templateUrl: 'templates/item-detail.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class ItemDetailComponent implements OnInit {
	constructor(params : RouteParams, private _router: Router, private _itemDetailService : ItemDetailService){
		this.idItem = params.get('item');
	}
	idItem : string;
	errorMessage : string;
	item = "";
	imageMain = "";
	

	ngOnInit(){ this.getItem(this.idItem);}

	getItem(idItem){
		this._itemDetailService.getItem(idItem)
									.subscribe(
										data => this.item = data,
										err => console.log(err),
										() => this.actionItem(this.item)
									);
	}

	actionItem(item){
		this.imageMain = item.media[0].url;
	}

}