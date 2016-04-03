import {User} from '../../models/user/user.model';
import {Item} from '../../interfaces/item';

export class CommentItem {

	public id : number;
	public text : string;
	public score : number;
	public dataEntry : string;
	public item : Item;
	public author : User;
	
	constructor (){
		
	}
}