import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Car} from '../models/car/car.model';
import {Payload} from '../models/car/payload.model';
import {CartDetail} from '../models/car/cart-detail.model';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class PayloadService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + "shoppingCart";

	sendPay (service : Payload) : Observable<Payload> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl, body, options)
						.map(res => <Payload> res.json())
						.catch(this.handleError)
	}

	sendCartDetail (item : CartDetail) : Observable<CartDetail> {
		let body = JSON.stringify(item);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl + "/" + item['transaction']['id'] + "/detail", body, options)
						.map(res => <CartDetail> res.json())
						.catch(this.handleError)	
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}