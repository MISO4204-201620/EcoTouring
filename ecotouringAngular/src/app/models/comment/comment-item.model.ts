import {User} from '../../models/user/user.model';
import {Item} from '../../interfaces/item';

export class CommentItem {

	public id : number;
	public text : string;
	public score : number;
	public dateEntry : Date;
	public item : Object;
	public author : User;
	
	constructor (){
		
	}
}