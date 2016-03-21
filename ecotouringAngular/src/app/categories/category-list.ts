import {Component, OnInit} from 'angular2/core';
import {Router} from 'angular2/router';
import {Category} from '../interfaces/category';
import {CategoryListService} from '../services/category-list.service';

@Component({
  selector: 'category-list',
  providers: [],
  templateUrl: 'templates/category-list.html',
  styleUrls :[],
  directives: [],
  pipes: []
})

export class CategoryListComponent implements OnInit {
  constructor(private _router: Router, private _categoryListService : CategoryListService){}

  errorMessage : string;
  categories : Category[];
  selectedCategory: Category;

  ngOnInit(){ this.getCategories();}

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