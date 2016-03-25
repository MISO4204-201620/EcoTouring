import {Component, OnInit} from 'angular2/core';
import {Location, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
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
  constructor(private _router: Router, private _commentItemService : CommentItemService){}

  errorMessage : string;
  comments : CommentItem[];
  selectedComment: CommentItem;
  totalComments : number;

  ngOnInit(){ 
    this.getComments();
  }

  getComments(){
  	this._commentItemService.getComments()
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