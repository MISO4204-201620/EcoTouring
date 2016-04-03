export class Payload {

	public type : string;
	public status : string;
	public customer : Object;
	public dateTransaction : string;
	
	
	constructor (){
		
		this.type = "";
		this.status = "";
		this.customer = { id: 0};
		this.dateTransaction = "";
	}
}