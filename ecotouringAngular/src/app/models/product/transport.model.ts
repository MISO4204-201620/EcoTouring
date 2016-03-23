export class Transport {

	public id : number;
	public name : string;
	public dateStart : Date;
	public dateEnd : Date;
	public people : number;
	public countryFrom : string;
	public cityFrom : string;
	public countryTo : string;
	public cityTo : string;
	public type : number;
	public description : string;
	public content : string;
	
	constructor (){
		this.id = 0;
		this.name = "";
		this.dateStart = new Date(Date.now());
		this.dateEnd = new Date(Date.now());
		this.people = 0,
		this.countryFrom = "",
		this.cityFrom = "";
		this.countryTo = "",
		this.cityTo = "";
		this.type = 1;
		this.description = "";
		this.content = "";
	}
}