import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {ItemThumb} from '../interfaces/item-thumb';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class ItemListService {
	constructor (private http : Http){}

	private _itemsUrl = 'mocks/items.json';
	//private _itemsUrl = 'http://54.174.139.165:9999/items';

	getItems(){
		return this.http.get(this._itemsUrl)
							.map(res => <ItemThumb[]> res.json().data)
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}