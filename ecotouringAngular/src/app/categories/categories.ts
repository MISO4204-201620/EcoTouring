import {Component} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {Category} from '../interfaces/category';
import {CategoryListComponent} from './category-list';
import {CategoryListService} from '../services/category-list.service';
import {ProviderListComponent} from '../components/providers/provider-list';
import {ProviderListService} from '../services/provider-list.service';
import {ItemListComponent} from '../components/products/item-list';
import {ItemApp} from '../components/products/item';


@Component({
  selector: 'categories-app',
  providers: [HTTP_PROVIDERS, CategoryListService, ProviderListService],
  templateUrl: 'templates/categories.html',
  styleUrls :[],
  directives: [CategoryListComponent, ProviderListComponent,ROUTER_DIRECTIVES],
  pipes: []
})

@RouteConfig([
  { 
    path: '/', 
    name: 'Items',
    component: ItemListComponent
  },
  { 
    path: '/:category', 
    name: 'Items',
    component: ItemListComponent
  },
  { 
    path: '/item/...', 
    name: 'Item',
    component: ItemApp
  }
])

export class CategoriesApp {
  constructor(public router: Router){}
}