import {Component} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {HTTP_PROVIDERS} from 'angular2/http';
import {Item} from '../../interfaces/item';
import {CategoryListComponent} from '../../categories/category-list';
import {CategoryListService} from '../../services/category-list.service';
import {ProviderListComponent} from '../providers/provider-list';
import {ProviderListService} from '../../services/provider-list.service';
import {ItemDetailComponent} from './item-detail';


@Component({
  selector: 'item-app',
  providers: [HTTP_PROVIDERS, CategoryListService, ProviderListService],
  templateUrl: 'templates/item.html',
  styleUrls :[],
  directives: [CategoryListComponent, ProviderListComponent,ROUTER_DIRECTIVES],
  pipes: []
})

@RouteConfig([
  { 
    path: '/:item', 
    name: 'ItemDetail',
    component: ItemDetailComponent
  }
])

export class ItemApp {
  constructor(public router: Router){}
}