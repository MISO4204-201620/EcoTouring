import {Injectable} from 'angular2/core';
import {Http, Response, Headers, RequestOptions} from 'angular2/http';
import {Message} from './messages.model';
import {Observable} from 'rxjs/Observable';
import {ConfigParams} from '../../config-params'

@Injectable()
export class MessagesService {

	constructor (private http : Http){}

	private config = new ConfigParams ();
	private _apiUrl = this.config.urlAPI;

	getMessages(id : number){
		return this.http.get(this._apiUrl + "people/" + id + "/messages")
							.map(res => <Message[]> res.json())
							.catch(this.handleError);
	}

	postMessages(message : Message) :  Observable<Message> {
		let body = JSON.stringify(message);
		console.log(body);
		let headers = new Headers({'Content-Type' : 'application/json'});
		let options = new RequestOptions({ headers : headers});

		return this.http.post(this._apiUrl + "messages", body, options)
						.map(res => <Message> res.json())
						.catch(this.handleError)
	}

	private handleError (error: Response){
		console.log(error);
		return Observable.throw(error.json().error || 'Server Error');
	}
}