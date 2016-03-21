import {Provider} from './provider';
import {Media} from './media';

export interface Item {
	id : number;
	name : string;
	description : string;
	price : number;
	type : string;
	supplier : Provider;
	content : string;
	score : string;
	media : [Media];
}