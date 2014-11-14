'use strict';

angular
  .module('letusgoApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'LocalStorageModule'
  ])
  .config(['localStorageServiceProvider', function(localStorageServiceProvider){
    localStorageServiceProvider.setPrefix('ls');
  }])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'client/app/views/home.html',
        controller: 'HomeCtrl'
      })
      .when('/itemsList', {
        templateUrl: 'client/app/views/itemsList.html',
        controller: 'ItemsListCtrl'
      })
      .when('/cartItemsList', {
        templateUrl: 'client/app/views/cartItemsList.html',
        controller: 'CartItemsListCtrl'
      })

      .when('/cartPayList', {
        templateUrl: 'client/app/views/cartPayList.html',
        controller: 'CartPayListCtrl'
      })
      .when('/categoryModify', {
        templateUrl: 'client/app/views/categoryModify.html',
        controller: 'CategoryModifyCtrl'
      })
      .when('/categoryAdd', {
        templateUrl: 'client/app/views/categoryAdd.html',
        controller: 'CategoryAddCtrl'
      })
      .when('/itemModify', {
        templateUrl: 'client/app/views/itemModify.html',
        controller: 'ItemModifyCtrl'
      })
      .when('/itemAdd', {
        templateUrl: 'client/app/views/itemAdd.html',
        controller: 'ItemAddCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
