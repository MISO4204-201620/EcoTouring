export class EcoTour {

	public name : string;
	public description : string;
	public price : number;
	public category : string;
	public itemType : string;
	public status : string;
	public tag : string;
	public urlImage : string;
	public ecoTourType : string;
	public contentType : string;
	public score : number;
	public supplier : Object;
	public itinerary : string;

	constructor (){
		this.name = "";
		this.description = "";
		this.price = 0;
		this.category = "ECOTOUR";
		this.itemType = "SINGLE";
		this.status = "HIDDEN";
		this.tag = "";
		this.urlImage = "";
		this.ecoTourType = "";
		this.contentType = "IMG_PNG";
		this.score = 0;
		this.supplier = { id : 0};
		this.itinerary = "";
	}
}