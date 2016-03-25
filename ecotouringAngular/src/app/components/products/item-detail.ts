import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS} from 'angular2/router';
import {Item} from '../../interfaces/item';
import {ItemDetailService} from '../../services/item-detail.service';
import {Car} from '../../models/car/car.model';

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
	itemsBucket : Array<Car>;
	

	ngOnInit(){ 
		this.getItem(this.idItem);
		this.itemsBucket = new Array;
	}

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

	onAddCartItem (item : Item) {
		if(typeof(Storage) !== "undefined"){
			
			if(sessionStorage.getItem('itemBucket')){
				let objBucket = sessionStorage.getItem('itemBucket');
				this.itemsBucket = JSON.parse(objBucket);
				let cartItem = new Car();
				cartItem.id = item.id;
				cartItem.name = item.name;
				cartItem.image = item.media[0].url;
				cartItem.amount = 1;
				cartItem.price = item.price;
				cartItem.discount = 0;
				cartItem.totalPrice = item.price;
				this.itemsBucket.push(cartItem);
				sessionStorage.setItem('itemBucket', JSON.stringify(this.itemsBucket));
				alert("El servicio fue adicionado al carrito de compras.");
			}else {
				let cartItem = new Car();
				cartItem.id = item.id;
				cartItem.name = item.name;
				cartItem.image = item.media[0].url;
				cartItem.amount = 1;
				cartItem.price = item.price;
				cartItem.discount = 0;
				cartItem.totalPrice = item.price;

				this.itemsBucket.push(cartItem);
				sessionStorage.setItem('itemBucket', JSON.stringify(this.itemsBucket));
				alert("El servicio fue adicionado al carrito de compras.");
			}
		}else {
			alert("Favor actualizar su explorador !");
		}
	}

}