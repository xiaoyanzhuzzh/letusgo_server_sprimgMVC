'use strict';


angular.module('letusgoApp')
  .controller('ItemModifyCtrl', function ($scope, CategoryService, ItemsService) {

    $scope.$emit('to-parent-itemManagementActive');

    $scope.items = [];
    ItemsService.getItems(function(data) {

      $scope.items = data;
    });

    $scope.categories = [];
    CategoryService.getCategories(function(data) {
      $scope.categories = data;
    });

    $scope.showItemSignal = false;

    $scope.modifyButton = function (item) {
      $scope.showItemSignal = true;
      console.log(item.category);

      $scope.itemInfo = {
        id: item.id,
        barcode: item.barcode,
        name: item.name,
        unit: item.unit,
        price: item.price,
        category: {
          id: item.category.id,
          name: item.category.name
        }
      };
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

    $scope.modifyCurrentItem = function (newItem) {
      console.log(newItem);
      ItemsService.putItem(newItem, function(){
        ItemsService.getItems(function(data) {
          $scope.items = data;
        });
      });
//      ItemsService.getItems(function(data) {
//        $scope.items = data;
//      });

      $scope.showItemSignal = false;
    };
  });
