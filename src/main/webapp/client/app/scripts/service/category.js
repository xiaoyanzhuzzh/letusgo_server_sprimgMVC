'use strict';

angular.module('letusgoApp')
  .service('CategoryService', function($http){

    function getCategoriesData(callback){

      $http.get('/api/categories')
       .success(function(data) {

         callback(data);
       });
    }

    function deleteCategoryData(id) {
      console.log(id);

      $http.delete('/api/categories/' + id);
    }

    function putCategoryData(category) {

      $http({method: 'PUT', url: '/api/categories/' + category.id, data:{id: category.id, name: category.name}});
    }

    function addCategoryData(category) {

      $http({method: 'POST', url: '/api/categories', data:{id: null, name: category.name}});
    }

    this.getCategories = function (callback) {

      getCategoriesData(function(data){

        callback(data);
      });
    };

    this.deleteCategory = function(id) {

      deleteCategoryData(id);
    };

    this.putCategory = function(category) {

      putCategoryData(category);
    };

    this.addCategory = function(category) {

      addCategoryData(category);
    };
  });
