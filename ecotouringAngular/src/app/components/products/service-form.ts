import {Component} from 'angular2/core';
import {NgForm}    from 'angular2/common';
//import {SelectButton} from 'primeng/primeng';

@Component({
  selector: 'service-form',
  templateUrl: 'templates/service-form.html'
})

export class ServiceFormComponent {
  
  model = '';
  submitted = false;
  onSubmit() { this.submitted = true; }
  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }
}