import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS} from 'angular2/router';
import {ItemThumb} from '../../interfaces/item-thumb';
import {Car} from '../../models/car/car.model';
import {CategoriesApp} from '../../categories/categories';
import {EcotouringwebApp} from '../../ecotouringweb';

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
	sStorage : string;


	ngOnInit(){ 
		
		let objUser = sessionStorage.getItem('userSession');
        let userToken = JSON.parse(objUser);
		this.sStorage = 'itemBucket'+ '_' + userToken.id;
		this.getItems();
	}

	getItems(){

		if(sessionStorage.getItem(this.sStorage)){
			let objBucket = sessionStorage.getItem(this.sStorage);
			this.carBucket = JSON.parse(objBucket);
			this.totalItems = this.carBucket.length;

			for (let i = 0; i < this.carBucket.length; i++){
				this.carBucket[i].totalPrice = this.carBucket[i].amount * this.carBucket[i].price;
			}

			this.calculateTotalPrice();
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

		if(sessionStorage.getItem(this.sStorage)){
			sessionStorage.setItem(this.sStorage, JSON.stringify(this.carBucket));
		}
	}

	goPayload() {
		let link = ['PayloadCart'];
		this._router.navigate(link);
	}

	/*onRouteLink(car : Car) {
		let link = ['Item', {item : car.id}];
		CategoriesApp.router.navigate(link);
	}
	*/	
}