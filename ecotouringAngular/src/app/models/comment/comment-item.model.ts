export class CommentItem {

	public id : number;
	public comment : string;
	public user : string;
	public image : string;
	public date : string;
	public score : number;
	
	constructor (){
		this.id = 0;
		this.comment = "";
		this.user = "";
		this.image = "",
		this.date = "",
		this.score = 0;
	}
}