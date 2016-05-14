import {Component, OnInit} from 'angular2/core';
import {Router,RouteParams,ROUTER_PROVIDERS} from 'angular2/router';
import {ItemThumb} from '../../interfaces/item-thumb';
import {Car} from '../../models/car/car.model';
import {CategoriesApp} from '../../categories/categories';
import {PayloadService} from '../../services/payload.service';
import {Payload} from '../../models/car/payload.model';
import {CartDetail} from '../../models/car/cart-detail.model';

@Component({
  selector: 'payload-cart',
  providers: [PayloadService],
  templateUrl: 'templates/payload-cart.html',
  styleUrls :[],
  directives: [],
  pipes: []
})


export class PayloadComponent implements OnInit {
	constructor(params : RouteParams, private _router: Router, private _payloadService : PayloadService){
		
	}

	errorMessage : string;
	carBucket : Car[];
	selectedItem: Car;
	totalItems : number;
	totalBucketPrice = 0;
	insurancePrice = 0;
	tax = 0.16;
	sStorage : string;
	payload : Payload;
	idUser : number;


	ngOnInit(){
		let objUser = sessionStorage.getItem('userSession');
        let userToken = JSON.parse(objUser);
        this.idUser = userToken.id;
		this.sStorage = 'itemBucket'+ '_' + userToken.id;
		this.getItems();
	}

	getItems(){

		if(sessionStorage.getItem(this.sStorage)){
			let objBucket = sessionStorage.getItem(this.sStorage);
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

	onPay(){


		let pay = new Payload();
		let today = new Date();
		pay.type = "PURSHASE";
		pay.status = "NEW";
		pay.customer =  { id : this.idUser};
		pay.dateTransaction = today.getFullYear() + "-" + today.getMonth() + "-" + today.getDate();

    	this._payloadService.sendPay(pay)
                  .subscribe(
                    pay => this.onPaySuccesfull(pay),
                    error => this.errorMessage = <any>error
                  );
	}

	onPaySuccesfull (pay) {
		
		let success = false;
		if(sessionStorage.getItem(this.sStorage)){
			let objBucket = sessionStorage.getItem(this.sStorage);
			this.carBucket = JSON.parse(objBucket);
			this.totalItems = this.carBucket.length;

			for (let i = 0; i < this.carBucket.length; i++){
				let cartDetail = new CartDetail();
				cartDetail.transaction = { id : pay.id};
				cartDetail.item = { itemId : this.carBucket[i].id};
				cartDetail.price = this.carBucket[i].price;
				cartDetail.quantity = this.carBucket[i].amount;

				this._payloadService.sendCartDetail(cartDetail)
	                  .subscribe(
	                    cartDetail => this.onPayDetail(i),
	                    error => this.errorMessage = <any>error
	                  );

	            
			}
		}
	}

	onPayDetail ( id : number) {
		if( (id + 1) === this.carBucket.length) {
        	alert("Pago exitoso");
        	sessionStorage.removeItem(this.sStorage);
        	this._router.navigate(['Home']);
        }
	}


}