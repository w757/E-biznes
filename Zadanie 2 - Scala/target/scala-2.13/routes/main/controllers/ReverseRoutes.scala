// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:9
package controllers {

  // @LINE:9
  class ReverseProductController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getAllProducts: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products")
    }
  
    // @LINE:10
    def getProductById(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:12
    def updateProduct(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:13
    def deleteProduct(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "products/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:11
    def createProduct: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "products")
    }
  
  }

  // @LINE:16
  class ReverseCategoryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def getAllCategories: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:19
    def updateCategory(id:Int): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "categories/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:18
    def createCategory: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "categories")
    }
  
    // @LINE:17
    def getCategoryById(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:20
    def deleteCategory(id:Int): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "categories/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
  }


}
