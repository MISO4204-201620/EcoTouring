export class CartDetail {

	public transaction : Object;
	public item : Object;
	public price : number;
	public quantity : number;
	
	
	constructor (){
		
		this.transaction = { id : 0};
		this.item = { itemId : 0};
		this.price = 0;
		this.quantity = 0;
	}
}