import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {ItemThumb} from '../interfaces/item-thumb';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ProviderItemsService {
	constructor (private http : Http){}

	private _itemsUrl = 'http://54.174.139.165:9999/suppliers/';

	getItems(param){

		return this.http.get(this._itemsUrl + param + '/items')
							.map(res => <ItemThumb[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
	
}