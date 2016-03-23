export class EcoTour {

	public id : number;
	public name : string;
	public date : Date;
	public people : number;
	public country : string;
	public city : string;
	public description : string;
	public content : string;

	constructor (){
		this.id = 0;
		this.name = "";
		this.date = new Date(Date.now());
		this.people = 0;
		this.country = "";
		this.city = "";
		this.description = "";
		this.content = "";
	}
}