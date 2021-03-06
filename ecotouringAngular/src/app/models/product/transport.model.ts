export class Transport {

	public name : string;
	public description : string;
	public price : number;
	public category : string;
	public itemType : string;
	public status : string;
	public tags : string;
	public urlImage : string;
	public type : string;
	public origin : string;
	public destination : string;
	public contentType : string;
	public score : number;
	public supplier : Object;
	public initialHour : string;
	public finalHour : string;

	constructor (){
		this.name = "";
		this.description = "";
		this.price = 0;
		this.category = "TRANSPORT";
		this.itemType = "SINGLE";
		this.status = "HIDDEN";
		this.tags = "";
		this.urlImage = "";
		this.type = "TAXY";
		this.contentType = "IMAGE_PNG";
		this.score = 0;
		this.supplier = { id : 0};
		this.initialHour = "";
		this.finalHour = "";
		this.origin = "";
		this.destination = "";
	}
}