export class User {

	public id : number;
	public fullName : string;
	public username : string;
	public email : string;
	public password : string;
	public jobTitle : string;
	public address : string;
	public role : string;
	
	constructor (){
		
		this.role = "USER";
	}
}