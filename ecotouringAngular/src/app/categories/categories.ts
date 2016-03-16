import {Component} from 'angular2/core';
import {Router} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {Category} from '../interfaces/category';
import {CategoryListComponent} from './category-list';
import {CategoryListService} from '../services/category-list.service';


@Component({
  selector: 'categories-app',
  providers: [HTTP_PROVIDERS, CategoryListService],
  templateUrl: 'templates/categories.html',
  styleUrls :[],
  directives: [CategoryListComponent],
  pipes: []
})

export class CategoriesApp {
  constructor(private _router: Router){}
}