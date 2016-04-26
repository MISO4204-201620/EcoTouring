import {bootstrap} from 'angular2/platform/browser';
import 'rxjs/Rx';
import {provideNglConfig} from 'ng-lightning/ng-lightning';
import {EcotouringwebApp} from './app/ecotouringweb';

bootstrap(EcotouringwebApp, [
	provideNglConfig( /* optional configuration object with overrides */ ),
]);