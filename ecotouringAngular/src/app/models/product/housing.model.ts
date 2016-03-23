export class Housing {
	constructor (
		public id : number,
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
}