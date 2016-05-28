import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Housing} from '../models/product/housing.model';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class HousingService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + 'accommodation';

	createService (service : Housing) : Observable<Housing> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl, body, options)
						.map(res => <Housing> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}