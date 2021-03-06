/* global require, module */

var Angular2App = require('angular-cli/lib/broccoli/angular2-app');

module.exports = function(defaults) {
  var app = new Angular2App(defaults, {
    vendorNpmFiles: ['ng-lightning/**/*', 'primeng/**/*', 'primeui/**/*', 'tether/**/*', '@salesforce-ux/**/*', 'hellojs/dist/*', 'angular2-jwt/**/*']
  });
  return app.toTree();
}