export class Message {

	public id : number;
	public conversationType : string;
	public entry : string;
	public user : string;
	public image : string;
	public dateEntry : string;
	public score : number;
	public author : string
	
	constructor (){
		this.id = 0;
		this.conversationType= "";
		this.entry = "";
		this.user = "";
		this.image = "",
		this.dateEntry = "",
		this.score = 0;
	}
}