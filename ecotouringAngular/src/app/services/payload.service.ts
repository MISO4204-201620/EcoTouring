import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Car} from '../models/car/car.model';
import {Payload} from '../models/car/payload.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PayloadService {
	constructor (private http : Http){}

	private _payloadUrl = 'http://54.174.139.165:9999/shoppingCart';

	sendPay (service : Payload) : Observable<Payload> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._payloadUrl, body, options)
						.map(res => <Payload> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}