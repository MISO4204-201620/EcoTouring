import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Category} from '../interfaces/category';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class CategoryListService {
	constructor (private http : Http){}

	private _categoriesUrl = 'mocks/categories.json';
	//private _categoriesUrl = 'http://54.174.139.165:9999/categories';

	getCategories(){
		return this.http.get(this._categoriesUrl)
							.map(res => <Category[]> res.json().data)
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}