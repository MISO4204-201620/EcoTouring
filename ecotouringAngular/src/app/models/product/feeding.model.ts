export class Feeding {

	public name : string;
	public description : string;
	public price : number;
	public category : string;
	public itemType : string;
	public status : string;
	public tags : string;
	public urlImage : string;
	public alimentationType : string;
	public contentType : string;
	public score : number;
	public supplier : Object;
	public calories : string;

	constructor (){
		this.name = "";
		this.description = "";
		this.price = 0;
		this.category = "ALIMENTATION";
		this.itemType = "SINGLE";
		this.status = "HIDDEN";
		this.tags = "";
		this.urlImage = "";
		this.alimentationType = "";
		this.contentType = "IMAGE_PNG";
		this.score = 0;
		this.supplier = { id : 0};
		this.calories = "";
	}
}