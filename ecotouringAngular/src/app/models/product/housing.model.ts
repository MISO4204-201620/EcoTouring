/*export class Housing {
	public name : string,
	public dateStart : Date,
	public dateEnd : Date,
	public description : string,
	public people : number,
	public country : string,
	public city : string,
	public price : number,
	public room : number,
	public content? : string
	constructor (
		public name : string,
		public dateStart : Date,
		public dateEnd : Date,
		public description : string,
		public people : number,
		public country : string,
		public city : string,
		public price : number,
		public room : number,
		public content? : string
	){}
}*/
import {User} from '../user/user.model';

export class Housing {
	public name : string;
	public description : string;
	public price : number;
	public numberOfRooms : number;
	public category : string;
	public itemType : string;
	public status : string;
	public country : string;
	public city : string;
	public tags : string;
	public urlImage : string;
	public accommodationType : string;
	public contentType : string;
	public score : number;
	public supplier : Object;
	public hotelName : string;

	constructor (){
		this.name = "";
		this.description = "";
		this.country = "";
		this.city = "";
		this.price = 0;
		this.numberOfRooms = 0;
		this.category = "ACCOMMODATION";
		this.itemType = "SINGLE";
		this.status = "HIDDEN";
		this.tags = "";
		this.urlImage = "";
		this.accommodationType = "SINGLE";
		this.contentType = "IMAGE_PNG";
		this.score = 0;
		this.supplier = { id : 0};
		this.hotelName = "";
	}
}