// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  ProductController_1: controllers.ProductController,
  // @LINE:16
  CategoryController_2: controllers.CategoryController,
  // @LINE:23
  CartController_3: controllers.CartController,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    ProductController_1: controllers.ProductController,
    // @LINE:16
    CategoryController_2: controllers.CategoryController,
    // @LINE:23
    CartController_3: controllers.CartController
  ) = this(errorHandler, HomeController_0, ProductController_1, CategoryController_2, CartController_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, ProductController_1, CategoryController_2, CartController_3, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.getAllProducts"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductController.getProductById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products""", """controllers.ProductController.createProduct"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductController.updateProduct(id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """products/""" + "$" + """id<[^/]+>""", """controllers.ProductController.deleteProduct(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.getAllCategories"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.getCategoryById(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.CategoryController.createCategory"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.updateCategory(id:Int)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories/""" + "$" + """id<[^/]+>""", """controllers.CategoryController.deleteCategory(id:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart""", """controllers.CartController.getCart"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart/add/""" + "$" + """productId<[^/]+>""", """controllers.CartController.addToCart(productId:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart/remove/""" + "$" + """productId<[^/]+>""", """controllers.CartController.removeFromCart(productId:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cart/checkout""", """controllers.CartController.checkout"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:6
  private lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:9
  private lazy val controllers_ProductController_getAllProducts1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private lazy val controllers_ProductController_getAllProducts1_invoker = createInvoker(
    ProductController_1.getAllProducts,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getAllProducts",
      Nil,
      "GET",
      this.prefix + """products""",
      """ Product routes""",
      Seq()
    )
  )

  // @LINE:10
  private lazy val controllers_ProductController_getProductById2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_ProductController_getProductById2_invoker = createInvoker(
    ProductController_1.getProductById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "getProductById",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private lazy val controllers_ProductController_createProduct3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private lazy val controllers_ProductController_createProduct3_invoker = createInvoker(
    ProductController_1.createProduct,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "createProduct",
      Nil,
      "POST",
      this.prefix + """products""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private lazy val controllers_ProductController_updateProduct4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_ProductController_updateProduct4_invoker = createInvoker(
    ProductController_1.updateProduct(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "updateProduct",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private lazy val controllers_ProductController_deleteProduct5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_ProductController_deleteProduct5_invoker = createInvoker(
    ProductController_1.deleteProduct(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ProductController",
      "deleteProduct",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """products/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private lazy val controllers_CategoryController_getAllCategories6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private lazy val controllers_CategoryController_getAllCategories6_invoker = createInvoker(
    CategoryController_2.getAllCategories,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getAllCategories",
      Nil,
      "GET",
      this.prefix + """categories""",
      """ Category routes""",
      Seq()
    )
  )

  // @LINE:17
  private lazy val controllers_CategoryController_getCategoryById7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CategoryController_getCategoryById7_invoker = createInvoker(
    CategoryController_2.getCategoryById(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "getCategoryById",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """categories/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private lazy val controllers_CategoryController_createCategory8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private lazy val controllers_CategoryController_createCategory8_invoker = createInvoker(
    CategoryController_2.createCategory,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "createCategory",
      Nil,
      "POST",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private lazy val controllers_CategoryController_updateCategory9_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CategoryController_updateCategory9_invoker = createInvoker(
    CategoryController_2.updateCategory(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "updateCategory",
      Seq(classOf[Int]),
      "PUT",
      this.prefix + """categories/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private lazy val controllers_CategoryController_deleteCategory10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CategoryController_deleteCategory10_invoker = createInvoker(
    CategoryController_2.deleteCategory(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CategoryController",
      "deleteCategory",
      Seq(classOf[Int]),
      "DELETE",
      this.prefix + """categories/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private lazy val controllers_CartController_getCart11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart")))
  )
  private lazy val controllers_CartController_getCart11_invoker = createInvoker(
    CartController_3.getCart,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "getCart",
      Nil,
      "GET",
      this.prefix + """cart""",
      """ Cart routes""",
      Seq()
    )
  )

  // @LINE:24
  private lazy val controllers_CartController_addToCart12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart/add/"), DynamicPart("productId", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CartController_addToCart12_invoker = createInvoker(
    CartController_3.addToCart(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "addToCart",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """cart/add/""" + "$" + """productId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private lazy val controllers_CartController_removeFromCart13_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart/remove/"), DynamicPart("productId", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CartController_removeFromCart13_invoker = createInvoker(
    CartController_3.removeFromCart(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "removeFromCart",
      Seq(classOf[Int]),
      "POST",
      this.prefix + """cart/remove/""" + "$" + """productId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private lazy val controllers_CartController_checkout14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cart/checkout")))
  )
  private lazy val controllers_CartController_checkout14_invoker = createInvoker(
    CartController_3.checkout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CartController",
      "checkout",
      Nil,
      "POST",
      this.prefix + """cart/checkout""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_ProductController_getAllProducts1_route(params@_) =>
      call { 
        controllers_ProductController_getAllProducts1_invoker.call(ProductController_1.getAllProducts)
      }
  
    // @LINE:10
    case controllers_ProductController_getProductById2_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ProductController_getProductById2_invoker.call(ProductController_1.getProductById(id))
      }
  
    // @LINE:11
    case controllers_ProductController_createProduct3_route(params@_) =>
      call { 
        controllers_ProductController_createProduct3_invoker.call(ProductController_1.createProduct)
      }
  
    // @LINE:12
    case controllers_ProductController_updateProduct4_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ProductController_updateProduct4_invoker.call(ProductController_1.updateProduct(id))
      }
  
    // @LINE:13
    case controllers_ProductController_deleteProduct5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ProductController_deleteProduct5_invoker.call(ProductController_1.deleteProduct(id))
      }
  
    // @LINE:16
    case controllers_CategoryController_getAllCategories6_route(params@_) =>
      call { 
        controllers_CategoryController_getAllCategories6_invoker.call(CategoryController_2.getAllCategories)
      }
  
    // @LINE:17
    case controllers_CategoryController_getCategoryById7_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_getCategoryById7_invoker.call(CategoryController_2.getCategoryById(id))
      }
  
    // @LINE:18
    case controllers_CategoryController_createCategory8_route(params@_) =>
      call { 
        controllers_CategoryController_createCategory8_invoker.call(CategoryController_2.createCategory)
      }
  
    // @LINE:19
    case controllers_CategoryController_updateCategory9_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_updateCategory9_invoker.call(CategoryController_2.updateCategory(id))
      }
  
    // @LINE:20
    case controllers_CategoryController_deleteCategory10_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_deleteCategory10_invoker.call(CategoryController_2.deleteCategory(id))
      }
  
    // @LINE:23
    case controllers_CartController_getCart11_route(params@_) =>
      call { 
        controllers_CartController_getCart11_invoker.call(CartController_3.getCart)
      }
  
    // @LINE:24
    case controllers_CartController_addToCart12_route(params@_) =>
      call(params.fromPath[Int]("productId", None)) { (productId) =>
        controllers_CartController_addToCart12_invoker.call(CartController_3.addToCart(productId))
      }
  
    // @LINE:25
    case controllers_CartController_removeFromCart13_route(params@_) =>
      call(params.fromPath[Int]("productId", None)) { (productId) =>
        controllers_CartController_removeFromCart13_invoker.call(CartController_3.removeFromCart(productId))
      }
  
    // @LINE:26
    case controllers_CartController_checkout14_route(params@_) =>
      call { 
        controllers_CartController_checkout14_invoker.call(CartController_3.checkout)
      }
  }
}
