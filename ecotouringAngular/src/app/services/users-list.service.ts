import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {User} from '../models/user/user.model';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class UserListService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + "people";
	
	getUsers(){
		return this.http.get(this._apiUrl)
							.map(res => <User[]> res.json())
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}