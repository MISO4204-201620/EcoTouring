import {Component, OnInit} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {Category} from './interfaces/category';
import {CategoryListService} from './services/category-list.service';

@Component({
  selector: 'categories-panel-app',
  providers: [],
  templateUrl: 'templates/categoriespanel.html',
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})
@RouteConfig([

])
export class CategoriesPanelApp implements OnInit {
	constructor(private _router: Router, private _categoryListService : CategoryListService){}

	errorMessage : string;
	categories : Category[];
	selectedCategory: Category;

	ngOnInit(){ this.getCategories(); }

	getCategories(){
		this._categoryListService.getCategories()
									.subscribe(
										categories => this.categories = categories,
										error => this.errorMessage = <any>error
									);
		}

		onSelect(category : Category) {
			this.selectedCategory = category;
		}
}