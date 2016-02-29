import {bootstrap} from 'angular2/platform/browser';
import {SearchComponentApp} from './app/searchcomponent';
import {CategoriesPanelApp} from './app/categoriespanel';
import {ROUTER_PROVIDERS} from 'angular2/router';

bootstrap(SearchComponentApp, [
  ROUTER_PROVIDERS
]);
bootstrap(CategoriesPanelApp, [
  ROUTER_PROVIDERS
]);