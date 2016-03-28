export class User {

	public fullName : string;
	public username : string;
	public email : string;
	public password : string;
	public jobTitle : string;
	public address : string;
	public role : string;
	
	constructor (){
		
		this.fullName = "";
		this.username = "";
		this.email = "";
		this.password = "",
		this.jobTitle = "",
		this.address = "";
		this.role = "USER";
	}
}