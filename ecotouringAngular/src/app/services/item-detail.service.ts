import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Item} from '../interfaces/item';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class ItemDetailService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + 'items/';
	

	getItem(idItem){
		return this.http.get(this._apiUrl + idItem)
							.map((res : Response) => res.json())
							.do(data => console.log(data))
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}