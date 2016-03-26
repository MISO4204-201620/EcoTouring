import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Provider} from '../interfaces/provider';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ProviderListService {
	constructor (private http : Http){}

	//private _providersUrl = 'mocks/providers.json';
	private _providersUrl = 'http://54.174.139.165:9999/suppliers';

	getProviders(){
		return this.http.get(this._providersUrl)
							.map(res => <Provider[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}