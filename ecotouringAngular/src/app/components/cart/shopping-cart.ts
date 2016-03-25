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
		this.carBucket = [
			{id : 1, name : "Viaje al Amazonas", image : "http://lorempixel.com/100/100/transport/", amount : 1, price : 400000, discount : 0, totalPrice : 400000},
			{id : 2, name : "Hotel Amazonas", image : "http://lorempixel.com/100/100/city/", amount : 1, price : 600000, discount : 0, totalPrice : 600000},
			{id : 3, name : "Visita Eco Parque", image : "http://lorempixel.com/100/100/nature/", amount : 1, price : 80000, discount : 0, totalPrice : 80000},
			{id : 4, name : "Visita Reserva Ecológica", image : "http://lorempixel.com/100/100/nature/", amount : 1, price : 60000, discount : 0, totalPrice : 60000}
		];

		this.calculateTotalPrice();

		this.totalItems = this.carBucket.length;
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