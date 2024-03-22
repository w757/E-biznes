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
  // @LINE:9
  ProductController_0: controllers.ProductController,
  // @LINE:16
  CategoryController_1: controllers.CategoryController,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:9
    ProductController_0: controllers.ProductController,
    // @LINE:16
    CategoryController_1: controllers.CategoryController
  ) = this(errorHandler, ProductController_0, CategoryController_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ProductController_0, CategoryController_1, prefix)
  }

  private val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
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
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:9
  private lazy val controllers_ProductController_getAllProducts0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private lazy val controllers_ProductController_getAllProducts0_invoker = createInvoker(
    ProductController_0.getAllProducts,
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
  private lazy val controllers_ProductController_getProductById1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_ProductController_getProductById1_invoker = createInvoker(
    ProductController_0.getProductById(fakeValue[Int]),
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
  private lazy val controllers_ProductController_createProduct2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products")))
  )
  private lazy val controllers_ProductController_createProduct2_invoker = createInvoker(
    ProductController_0.createProduct,
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
  private lazy val controllers_ProductController_updateProduct3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_ProductController_updateProduct3_invoker = createInvoker(
    ProductController_0.updateProduct(fakeValue[Int]),
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
  private lazy val controllers_ProductController_deleteProduct4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("products/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_ProductController_deleteProduct4_invoker = createInvoker(
    ProductController_0.deleteProduct(fakeValue[Int]),
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
  private lazy val controllers_CategoryController_getAllCategories5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private lazy val controllers_CategoryController_getAllCategories5_invoker = createInvoker(
    CategoryController_1.getAllCategories,
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
  private lazy val controllers_CategoryController_getCategoryById6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CategoryController_getCategoryById6_invoker = createInvoker(
    CategoryController_1.getCategoryById(fakeValue[Int]),
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
  private lazy val controllers_CategoryController_createCategory7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private lazy val controllers_CategoryController_createCategory7_invoker = createInvoker(
    CategoryController_1.createCategory,
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
  private lazy val controllers_CategoryController_updateCategory8_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CategoryController_updateCategory8_invoker = createInvoker(
    CategoryController_1.updateCategory(fakeValue[Int]),
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
  private lazy val controllers_CategoryController_deleteCategory9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories/"), DynamicPart("id", """[^/]+""", encodeable=true)))
  )
  private lazy val controllers_CategoryController_deleteCategory9_invoker = createInvoker(
    CategoryController_1.deleteCategory(fakeValue[Int]),
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


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:9
    case controllers_ProductController_getAllProducts0_route(params@_) =>
      call { 
        controllers_ProductController_getAllProducts0_invoker.call(ProductController_0.getAllProducts)
      }
  
    // @LINE:10
    case controllers_ProductController_getProductById1_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ProductController_getProductById1_invoker.call(ProductController_0.getProductById(id))
      }
  
    // @LINE:11
    case controllers_ProductController_createProduct2_route(params@_) =>
      call { 
        controllers_ProductController_createProduct2_invoker.call(ProductController_0.createProduct)
      }
  
    // @LINE:12
    case controllers_ProductController_updateProduct3_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ProductController_updateProduct3_invoker.call(ProductController_0.updateProduct(id))
      }
  
    // @LINE:13
    case controllers_ProductController_deleteProduct4_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_ProductController_deleteProduct4_invoker.call(ProductController_0.deleteProduct(id))
      }
  
    // @LINE:16
    case controllers_CategoryController_getAllCategories5_route(params@_) =>
      call { 
        controllers_CategoryController_getAllCategories5_invoker.call(CategoryController_1.getAllCategories)
      }
  
    // @LINE:17
    case controllers_CategoryController_getCategoryById6_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_getCategoryById6_invoker.call(CategoryController_1.getCategoryById(id))
      }
  
    // @LINE:18
    case controllers_CategoryController_createCategory7_route(params@_) =>
      call { 
        controllers_CategoryController_createCategory7_invoker.call(CategoryController_1.createCategory)
      }
  
    // @LINE:19
    case controllers_CategoryController_updateCategory8_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_updateCategory8_invoker.call(CategoryController_1.updateCategory(id))
      }
  
    // @LINE:20
    case controllers_CategoryController_deleteCategory9_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_CategoryController_deleteCategory9_invoker.call(CategoryController_1.deleteCategory(id))
      }
  }
}
