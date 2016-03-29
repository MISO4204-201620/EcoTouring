import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Feeding} from '../models/product/feeding.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class FeedingService {
	constructor (private http : Http){}

	private _feedingUrl = 'http://54.174.139.165:9999/alimentation';

	createService (service : Feeding) : Observable<Feeding> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._feedingUrl, body, options)
						.map(res => <Feeding> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}