import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Category} from '../interfaces/category';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class CategoryListService {
	constructor (private http : Http){}

	private _categoriesUrl = 'mocks/categories.json';
	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + 'categories/';

	getCategories(){
		return this.http.get(this._categoriesUrl)
							.map(res => <Category[]> res.json().data)
							.catch(this.handleError);
	}

	getCategoriesCount(){
		return this.http.get(this._apiUrl)
							.map(res => <Object[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}