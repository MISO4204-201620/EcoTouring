import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {ItemThumb} from '../interfaces/item-thumb';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class ItemListService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI;

	getItems(param = 'items'){

		if (param === null) param = 'items';

		return this.http.get(this._apiUrl + param)
							.map(res => <ItemThumb[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}