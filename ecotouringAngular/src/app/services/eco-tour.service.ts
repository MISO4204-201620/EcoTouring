import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {EcoTour} from '../models/product/eco-tour.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class EcoTourService {
	constructor (private http : Http){}

	private _ecoTourUrl = 'http://54.174.139.165:9999/ecotour';

	createService (service : EcoTour) : Observable<EcoTour> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._ecoTourUrl, body, options)
						.map(res => <EcoTour> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}