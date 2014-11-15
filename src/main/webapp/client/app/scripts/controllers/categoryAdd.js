'use strict';


angular.module('letusgoApp')
  .controller('CategoryAddCtrl', function ($scope, ItemsService, CategoryService) {

    $scope.$emit('to-parent-categoryManagementActive');

    $scope.items = [];
    ItemsService.getItems(function(data) {
      $scope.items = data;
    });

    $scope.categories = [];
    CategoryService.getCategories(function(data) {
      $scope.categories = data;
    });

    $scope.showSignal = false;

    $scope.addButton = function () {

        $scope.showSignal = true;

    };
    $scope.cancelButton = function () {

      $scope.showSignal = false;
    };

    $scope.deleteCurrentCategory = function (category) {

      CategoryService.deleteCategory(category.id, function(){
        CategoryService.getCategories(function(data) {
          $scope.categories = data;
        });
      });
    };

    $scope.addNewCategory = function (newCategory) {

      CategoryService.addCategory(newCategory, function(){
        CategoryService.getCategories(function(data) {
          $scope.categories = data;
        });

        $scope.showSignal = false;
      });
    };
  });
