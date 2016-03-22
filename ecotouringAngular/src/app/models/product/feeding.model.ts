export class Feeding {
	constructor (
		public id : number,
		public name : string,
		public dateStart : Date,
		public dateEnd : Date,
		public people : number,
		public country : string,
		public city : string,
		public options : Array<string>
	){}
}