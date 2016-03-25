import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {CommentItem} from '../models/comment/comment-item.model';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class CommentItemService {
	constructor (private http : Http){}

	private _commentsUrl = 'mocks/comments.json';
	//private _categoriesUrl = 'http://54.174.139.165:9999/categories';

	getComments(){
		return this.http.get(this._commentsUrl)
							.map(res => <CommentItem[]> res.json().data)
							.catch(this.handleError);
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}