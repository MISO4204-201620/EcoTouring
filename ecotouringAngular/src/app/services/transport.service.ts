import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Transport} from '../models/product/transport.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class TransportService {
	constructor (private http : Http){}

	private _transportUrl = 'http://54.174.139.165:9999/transport';

	createService (service : Transport) : Observable<Transport> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._transportUrl, body, options)
						.map(res => <Transport> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}