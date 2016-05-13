import {Component, OnInit, Input} from 'angular2/core';
import {Location,RouteParams, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
//import {Rating} from 'primeng/primeng';
import {NGL_DIRECTIVES} from 'ng-lightning/ng-lightning';
import {CommentItem} from '../../models/comment/comment-item.model';
import {CommentItemService} from '../../services/comment-item.service';
import {User} from '../../models/user/user.model';

@Component({
  selector: 'comment-item',
  providers: [CommentItemService],
  templateUrl: 'templates/comments-item.html',
  styleUrls :['assets/styles/salesforce-lightning-design-system.css'],
  directives: [ROUTER_DIRECTIVES, NGL_DIRECTIVES],
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
  isLogged = false;
  userToken : User;
  newComment : CommentItem;

  
  valueComment = 0;
  readonlyComment = false;
  size = 'small';

  private sizes = ['x-small', 'small', '', 'large'];

  changeSize() {
    this.size = this.sizes[(this.sizes.indexOf(this.size) + 1) % this.sizes.length];
  }

  ngOnInit(){ 
    this.getComments(this.itemId);
    if(sessionStorage.getItem('userSession')){
        let objUser = sessionStorage.getItem('userSession');
        this.userToken = JSON.parse(objUser);
        this.isLogged = true;
    }
    this.newComment = new CommentItem();
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

  onSubmit(comment : CommentItem){
    comment.item = { itemId : this.itemId};
    comment.author = this.userToken;
    comment.dateEntry = new Date(Date.now());
    comment.score = this.valueComment;

    this._commentItemService.postComments(this.itemId, comment)
                  .subscribe(
                    comment => this.onCommentSuccesfull(comment),
                    error => this.errorMessage = <any>error
                  );
    console.log(comment);
  }

  onCommentSuccesfull (comment : CommentItem){
    alert("Comentario enviado con éxito");
    this.getComments(this.itemId);

  }

}