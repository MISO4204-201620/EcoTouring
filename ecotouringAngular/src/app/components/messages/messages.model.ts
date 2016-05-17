import {User} from '../../models/user/user.model';

export class Message {

	public id : number;
	public subject : string;
	public body : string;
	public sender : User;
	public receiver : User;
	public dateEntry : Date;
	public status : string;
	
	constructor (){
		this.status = "UNREAD";
	}
}