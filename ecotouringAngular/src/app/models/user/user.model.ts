export class User {

	public id : number;
	public name : string;
	public email : string;
	public password : string;
	public phone : string;
	public address : string;
	public type : number;
	
	constructor (){
		this.id = 0;
		this.name = "";
		this.email = "";
		this.password = "",
		this.phone = "",
		this.address = "";
		this.type = 0;
	}
}