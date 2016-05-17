import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {CommentItem} from '../models/comment/comment-item.model';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../config-params';

@Injectable()
export class CommentItemService {
	constructor (private http : Http){}

	//private _commentsUrl = 'mocks/comments.json';
	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI + 'items';
	

	getComments(id : string){
		return this.http.get(this._apiUrl + id + "/scores")
							.map(res => <CommentItem[]> res.json())
							.catch(this.handleError);
	}

	postComments(id : string, comment : CommentItem) :  Observable<CommentItem> {
		let body = JSON.stringify(comment);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl + id + "/scores", body, options)
						.map(res => <CommentItem> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}