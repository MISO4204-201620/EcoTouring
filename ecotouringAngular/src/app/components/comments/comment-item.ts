import {Component, OnInit, Input} from 'angular2/core';
import {Location,RouteParams, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {CommentItem} from '../../models/comment/comment-item.model';
import {CommentItemService} from '../../services/comment-item.service';

@Component({
  selector: 'comment-item',
  providers: [CommentItemService],
  templateUrl: 'templates/comments-item.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES],
  pipes: []
})

export class CommentItemComponent implements OnInit {

  
  constructor(params : RouteParams,private _router: Router, private _commentItemService : CommentItemService){
    this.itemId = params.get('item');
  }

  itemId :string;
  errorMessage : string;
  comments : CommentItem[];
  selectedComment: CommentItem;
  totalComments : number;
  urlImage = "http://lorempixel.com/100/100/people/";

  ngOnInit(){ 
    this.getComments(this.itemId);
  }

  getComments(id : string){
  	this._commentItemService.getComments(id)
  								.subscribe(
  									comments => this.comments = comments,
  									error => this.errorMessage = <any>error,
                    () => this.totalComments = this.comments.length
  								);
  }

  onSelect(comment : CommentItem) {
  	this.selectedComment = comment;
  }
}