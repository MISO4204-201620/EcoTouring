import {Component, OnInit, Input} from 'angular2/core';
import {Location,RouteParams, RouteConfig, RouterLink, Router,ROUTER_DIRECTIVES,ROUTER_PROVIDERS} from 'angular2/router';
import {NgForm,CORE_DIRECTIVES, FORM_DIRECTIVES, NgClass, NgStyle}    from 'angular2/common';
import {NGL_DIRECTIVES} from 'ng-lightning/ng-lightning';
import {User} from '../../models/user/user.model';
import {Message} from './messages.model';
import {MessagesService} from './messages.service';

@Component({
  selector: 'messages-inbox',
  providers: [MessagesService],
  templateUrl: './app/components/messages/messages-inbox.html',
  styleUrls :[],
  directives: [ROUTER_DIRECTIVES, NGL_DIRECTIVES, NgClass, NgStyle, CORE_DIRECTIVES, FORM_DIRECTIVES],
  pipes: []
})

export class MessagesComponent implements OnInit {

	errorMessage = false;
	messages : Message[];
	totalMessages : number;
	urlImage = "http://lorempixel.com/100/100/people/";
	isLogged = false;
	userToken : User;
	newMessage : Message;
	opened: boolean = false;
  	sizeModal: string;
  	senderActive : User;
	
	constructor(params : RouteParams,private _router: Router, private _messageService : MessagesService){
    	
  	}

  	ngOnInit(){ 

	    if(sessionStorage.getItem('userSession')){
	        let objUser = sessionStorage.getItem('userSession');
	        this.userToken = JSON.parse(objUser);
	        this.isLogged = true;
	        this.getMessages(this.userToken.id);
	        this.newMessage = new Message();
	    }
  	}

  	getMessages(id : number){
	  	this._messageService.getMessages(id)
								.subscribe(
									messages => this.messages = messages,
									error => this.onErrorMessage(<any>error),
									() => this.totalMessages = this.messages.length
								);
  	}

  	onErrorMessage (error : any) {
		this.errorMessage = true;
		this.totalMessages = 0;
	}

	open(size: string, sender: User) {
	    this.sizeModal = size;
	    this.opened = !this.opened;
	    this.newMessage = new Message();
	    this.senderActive = sender;
	}

	cancel() {
		this.opened = false;
	}

	onSubmitMessage(message : Message) {
	    message.sender = this.userToken;
	    message.receiver = this.senderActive ;
	    message.dateEntry = new Date(Date.now());

	    this._messageService.postMessages(message)
	                  .subscribe(
	                    message => this.onMessageSuccesfull(message),
	                    error => this.errorMessage = <any>error
	                  );
	}

	onMessageSuccesfull (message : Message){
	    alert("Mensaje enviado con éxito");
	}
}