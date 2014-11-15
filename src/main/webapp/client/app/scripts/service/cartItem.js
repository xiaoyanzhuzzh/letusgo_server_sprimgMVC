'use strict';

angular.module('letusgoApp')
  .service('CartItemsService', function($http){

    function isExistInCart(id, cartItems) {
      var item;
      for (var i = 0; i < cartItems.length; i++){

        if (id === cartItems[i].item.id){
          item = cartItems[i];
        }
      }
      return item;
    }

    function updateCartItems(item, cartItems) {
      var cartItem = isExistInCart(item.id, cartItems);
      if (cartItem) {
        cartItem.num += 1;
        modifyCartItemNumberData(cartItem);
      }
      else{
        var newCartItem = {item: item, num: 1};
        cartItems.push(newCartItem);

        setCartItemsData(newCartItem);
      }
    }

    function findCartItem(cartItems, id){

      return _.find(cartItems, function(cartItem) {
        return cartItem.item.id === id;
      });
    }

    function addCartItemNumberData(cartItems, id){

      var cartItem = findCartItem(cartItems, id);

      cartItem.num += 1;
      return cartItem;
    }

    function reduceCartItemNumberData(cartItems, id){

      var cartItem = findCartItem(cartItems, id);

      if(cartItem.num > 1){
        cartItem.num -= 1;
      }
      return cartItem;
    }

    function getCartItemsData(callback) {

      $http.get('/api/cartItems')
        .success(function(data) {
          callback(data);
        });
    }

    function setCartItemsData(cartItem) {

      $http({method: 'POST', url: '/api/cartItems',
        data: {id: null, item: cartItem.item, num: cartItem.num}});
    }

    function deleteCartItemData(id) {

      $http.delete('/api/cartItems/' + id);
    }

    function emptyCartItemsData(){

      $http.delete('/api/payment');
    }

    function modifyCartItemNumberData(cartItem, callback) {

      $http({method: 'PUT', url: '/api/cartItems/' + cartItem.id,
        data:{id: cartItem.id, item: cartItem.item, num: cartItem.num}})
        .success(function(){
          callback();
      });
    }

    this.getCartItems = function(callback) {

      getCartItemsData(function(data) {

        callback(data);
      });
    };

    this.setCartItems = function(item) {

      this.getCartItems(function(data) {

        updateCartItems(item, data);
      });
    };

    this.addCartItemNumber = function(id, callback) {

      this.getCartItems(function(data) {

        modifyCartItemNumberData(addCartItemNumberData(data, id));
        callback();
      });
    };

    this.reduceCartItemNumber = function(id, callback) {

      this.getCartItems(function(data) {

        modifyCartItemNumberData(reduceCartItemNumberData(data, id));
        callback();
      });
    };

    this.changeCartItemNumber = function(changeCartItem, callback) {

        modifyCartItemNumberData(changeCartItem ,function(){
          callback();
        });
    };

    this.deleteCartItem = function(id) {

      deleteCartItemData(id);
    };

    this.emptyCartItems = function() {

      emptyCartItemsData();
    };

    this.getTotalNumber = function(array){
        var totalNum = 0;
        if(!array){
          array = [];
        }
        for(var i = 0; i < array.length; i++){
            totalNum += array[i].num;
        }
        return totalNum;
    };

    this.getTotalMoney = function(array){
        var total = 0;
        if(!array){
          array = [];
        }
        for(var i = 0; i < array.length; i++){
            total += array[i].num * array[i].item.price;
        }
        return total;
    };
  });
