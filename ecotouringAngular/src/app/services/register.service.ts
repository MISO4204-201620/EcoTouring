import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {User} from '../models/user/user.model';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class RegisterService {
	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + "people";
	
	createUser (user : User) : Observable<User> {
		let body = JSON.stringify(user);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl, body, options)
						.map(res => <User> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}