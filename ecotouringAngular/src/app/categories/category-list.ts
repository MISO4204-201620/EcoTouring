import {Component, OnInit} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {Category} from '../interfaces/category';
import {CategoryListService} from '../services/category-list.service';

@Component({
  selector: 'category-list',
  providers: [],
  templateUrl: 'templates/category-list.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class CategoryListComponent implements OnInit {
  constructor(private _router: Router, private _categoryListService : CategoryListService){}

  errorMessage : string;
  categories : Category[];
  selectedCategory: Category;
  categoriesCount : Object[];

  ngOnInit(){ 
    this.getCategories();
    this.getCategoriesCount();
  }

  getCategories(){
  	this._categoryListService.getCategories()
  								.subscribe(
  									categories => this.categories = categories,
  									error => this.errorMessage = <any>error
  								);
  }

  getCategoriesCount(){
    this._categoryListService.getCategoriesCount()
                  .subscribe(
                    categoriesCount => this.categoriesCount = categoriesCount,
                    error => this.errorMessage = <any>error,
                    () => this.onGetCategories(this.categoriesCount)
                  );
  }

  onGetCategories(categoriesCount : Object[]) {
     this.categories[0].total = categoriesCount[3]['size'];
     this.categories[1].total = categoriesCount[1]['size'];
     this.categories[2].total = categoriesCount[0]['size'];
     this.categories[3].total = categoriesCount[2]['size'];
  }

  onSelect(category : Category) {
  	this.selectedCategory = category;
  }
}