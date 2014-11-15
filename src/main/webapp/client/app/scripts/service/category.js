'use strict';

angular.module('letusgoApp')
  .service('CategoryService', function($http){

    function getCategoriesData(callback){

      $http.get('/api/categories')
       .success(function(data) {

         callback(data);
       });
    }

    function deleteCategoryData(id, callback) {

      $http.delete('/api/categories/' + id)
        .success(function(){

          callback();
      });
    }

    function putCategoryData(category, callback) {

      $http({method: 'PUT', url: '/api/categories/' + category.id,
        data:{id: category.id, name: category.name}})
        .success(function(){

          callback();
      });
    }

    function addCategoryData(category, callback) {

      $http({method: 'POST', url: '/api/categories', data:{id: null, name: category.name}})
        .success(function(){

          callback();
      });
    }

    this.getCategories = function (callback) {

      getCategoriesData(function(data){

        callback(data);
      });
    };

    this.deleteCategory = function(id, callback) {

      deleteCategoryData(id, function(){
        callback();
      });
    };

    this.putCategory = function(category, callback) {

      putCategoryData(category, function(){
        callback();
      });
    };

    this.addCategory = function(category, callback) {

      addCategoryData(category, function(){
        callback();
      });
    };
  });
