import {User} from '../../models/user/user.model';

export class Blog {

	public id : number;
	public title : string;
	public text : string;
	public author : User;
	public date : Date;
	public slug : string;
	
	constructor (){
		
	}
}