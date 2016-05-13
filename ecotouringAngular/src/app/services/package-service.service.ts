import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Package} from '../models/product/package.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class PackageService {
	constructor (private http : Http){}

	private _housingUrl = 'http://54.174.139.165:9999/items';

	createService (service : Package) : Observable<Package> {
		let body = JSON.stringify(service);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._housingUrl, body, options)
						.map(res => <Package> res.json())
						.catch(this.handleError)
	}

	addItemPackage (idPackage : number, idItem : number)  {
		let url = "http://54.174.139.165:9999/items/" + idPackage + "/packageDetail/" + idItem;
		let body = "";
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(url, body, options)
						.map(res => <any> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}