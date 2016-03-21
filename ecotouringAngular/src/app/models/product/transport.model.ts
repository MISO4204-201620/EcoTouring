export class Transport {
	constructor (
		public id : number,
		public name : string,
		public dateStart : Date,
		public dateEnd : Date,
		public people : number,
		public country : string,
		public city : string,
		hourStart : string,
		hourEnd : string
	){}
}