import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Provider} from '../interfaces/provider';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class ProviderListService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + "suppliers";

	getProviders(){
		return this.http.get(this._apiUrl)
							.map(res => <Provider[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}