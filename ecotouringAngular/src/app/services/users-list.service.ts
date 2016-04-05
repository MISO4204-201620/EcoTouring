import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {User} from '../models/user/user.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UserListService {
	constructor (private http : Http){}

	//private _categoriesUrl = 'mocks/categories.json';
	private _usersUrl = 'http://54.174.139.165:9999/people';
	//private _usersUrl = 'http://192.168.220.85:9999/people';

	getUsers(){
		return this.http.get(this._usersUrl)
							.map(res => <User[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}