import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES, Router} from 'angular2/router';
import {Category} from './interfaces/category';
import {CategoryListService} from './services/category-list.service';
import {UserListService} from './services/users-list.service';
import {User} from './models/user/user.model'

@Component({
  selector: 'counter-app',
  providers: [],
  templateUrl: 'templates/counter.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})
@RouteConfig([

])
export class CounterApp {
  constructor(private _router: Router, private _categoryListService : CategoryListService, private _userListService : UserListService){}

  countPlaces : number;
  countUsers : number;
  countHotels : number;
  countRestaurants : number;
  categoriesCount : Object[];
  errorMessage : string;
  users : User[];

  ngOnInit(){ 
    this.getCategoriesCount();
    this.onUserCount();
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
     this.countPlaces = categoriesCount[3]['size'];
     this.countHotels = categoriesCount[1]['size'];
     this.countRestaurants = categoriesCount[0]['size'];
     //this.countRestaurants = categoriesCount[2]['size'];
  }

  onUserCount(){ 

    this._userListService.getUsers()
                  .subscribe(
                    users => this.countUser(users),
                    error => this.errorMessage = <any>error
                  );

  }

  countUser (users :User[]){
  	this.countUsers = users.length;
  }
}