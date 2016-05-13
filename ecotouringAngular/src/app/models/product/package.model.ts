export class Package {

	public itemId	: number;
	public name : string;
	public description : string;
	public price : number;
	public category : string;
	public itemType : string;
	public status : string;
	public tags : string;
	public urlImage : string;
	public contentType : string;
	public score : number;
	public supplier : Object;

	constructor (){
		this.name = "";
		this.description = "";
		this.price = 0;
		this.category = "BASIC";
		this.itemType = "PACKAGE";
		this.status = "HIDDEN";
		this.tags = "";
		this.urlImage = "";
		this.contentType = "IMAGE_PNG";
		this.score = 0;
		this.supplier = { id : 0};
	}
}