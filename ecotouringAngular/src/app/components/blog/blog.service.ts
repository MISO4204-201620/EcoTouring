import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Blog} from './blog.model';
import {ConfigParams} from '../../config-params'
import {Observable} from 'rxjs/Observable';

@Injectable()
export class BlogService {

	constructor (private http : Http){}
	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + 'articles/';

	getEntries(){
		return this.http.get(this._apiUrl)
							.map(res => <Blog[]> res.json())
							.catch(this.handleError);
	}

	createEntry (entry : Blog) : Observable<Blog> {
		let body = JSON.stringify(entry);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl, body, options)
						.map(res => <Blog> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}

}