import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Item} from '../interfaces/item';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class ItemDetailService {
	constructor (private http : Http){}

	//private _itemUrl = 'mocks/item.json';
	private _itemUrl = 'http://54.174.139.165:9999/item/';

	getItem(idItem){
		return this.http.get(this._itemUrl + idItem)
							.map((res : Response) => res.json().data)
							.do(data => console.log(data))
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}