export class Car {

	public id : number;
	public name : string;
	public image : string;
	public amount : number;
	public price : number;
	public discount : number;
	public totalPrice : number;
	
	constructor (){
		this.id = 0;
		this.name = "";
		this.image = "";
		this.amount = 0,
		this.price = 0,
		this.discount = 0;
		this.totalPrice = 0;
	}
}