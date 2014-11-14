'use strict';


angular.module('letusgoApp')
  .controller('ItemAddCtrl', function ($scope, ItemsService, CategoryService) {

    $scope.$emit('to-parent-itemManagementActive');

    $scope.items = [];
    ItemsService.getItems(function(data) {
      $scope.items = data;
    });

    $scope.categories = [];
    CategoryService.getCategories(function(data) {
      $scope.categories = data;
      console.log($scope.categories);

    });

    $scope.showItemSignal = false;

    $scope.addButton = function () {

      $scope.showItemSignal = true;
    };

    $scope.cancelButton = function () {

      $scope.showItemSignal = false;
    };

    $scope.deleteCurrentItem = function (item) {

      ItemsService.deleteItem(item.id);
      ItemsService.getItems(function(data) {
        $scope.items = data;
      });
    };

    $scope.addNewItem = function (item) {

      console.log(item.category);

      CategoryService.getCategories(function(data) {
        console.log(data);
        var index = _.findIndex(data, function(category){
          return category.name = item.category.name;
        });

        item.category = data[index];
        console.log(item.category);

        ItemsService.addItem(item);
        ItemsService.getItems(function(items) {
          $scope.items = items;
        });
        $scope.showItemSignal = false;

      });
//      var index = _.findIndex($scope.categories, function(category){
//        return category.name = item.category.name;
//      });
//
//      item.category = $scope.categories[index];
//      console.log(item.category);
//
//      ItemsService.addItem(item);
//      ItemsService.getItems(function(data) {
//        $scope.items = data;
//      });
//      $scope.showItemSignal = false;
   };
});
