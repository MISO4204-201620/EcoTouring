import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS} from 'angular2/router';
import {ItemThumb} from '../../interfaces/item-thumb';
import {Car} from '../../models/car/car.model';

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
	carBucket : Car[];
	selectedItem: Car;
	totalItems : number;
	totalBucketPrice = 0;
	insurancePrice = 0;
	tax = 0.16;

	ngOnInit(){ 
		this.getItems();
	}

	getItems(){

		if(sessionStorage.getItem('itemBucket')){
			let objBucket = sessionStorage.getItem('itemBucket');
			this.carBucket = JSON.parse(objBucket);
			this.calculateTotalPrice();
			this.totalItems = this.carBucket.length;
		}
	}

	calculateTotalPrice (){
		this.totalBucketPrice = 0;
		for (let i = 0; i < this.carBucket.length; i++){
			this.totalBucketPrice += this.carBucket[i].totalPrice;
		}
	}

	onSelect(item : Car) {
		this.selectedItem = item;
	}

	getTotalItem (item : Car) {
		item.totalPrice = item.amount * item.price;
		this.calculateTotalPrice();
	}

	onDeleteCarItem (item : Car) {
		let pos = this.carBucket.indexOf(item);
		this.carBucket.splice(pos,1);
		this.calculateTotalPrice();
	}
	
}