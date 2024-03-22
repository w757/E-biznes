package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import scala.collection.mutable.ListBuffer
import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Category(id: Int, name: String)

object CategoryList {
  // Sample category list
  val categories: ListBuffer[Category] = ListBuffer(
    Category(1, "Electronics"),
    Category(2, "Clothing")
  )
}


case class Product(id: Int, name: String, price: Double, category: String)

object ProductList {
  // Sample product list
  val products: ListBuffer[Product] = ListBuffer(
    Product(1, "Smartphone", 599.99, "Electronics"),
    Product(2, "Laptop", 999.99, "Electronics")
  )

  var categoriesSet: Set[String] = products.map(_.category).toSet
}

@Singleton
class ProductController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  implicit val productWrites: Writes[Product] = Json.writes[Product]
  implicit val productReads: Reads[Product] = (
    (JsPath \ "id").read[Int] and
    (JsPath \ "name").read[String] and
    (JsPath \ "price").read[Double] and
    (JsPath \ "category").read[String]
  )(Product.apply _)

  // GET /products
  def getAllProducts: Action[AnyContent] = Action {
    Ok(Json.toJson(ProductList.products.toList))
  }

  // GET /products/:id
  def getProductById(id: Int): Action[AnyContent] = Action { implicit request =>
    ProductList.products.find(_.id == id) match {
      case Some(product) => Ok(Json.toJson(product))
      case None => NotFound(Json.obj("error" -> "Product not found"))
    }
  }

  // POST /products/
  def createProduct: Action[JsValue] = Action(parse.json) { implicit request =>
    request.body.validate[Product].fold(
      errors => BadRequest(Json.obj("error" -> JsError.toJson(errors))),
      product => {
        val newProductId = if (ProductList.products.isEmpty) 1 else ProductList.products.map(_.id).max + 1
        val newProduct = product.copy(id = newProductId)
        ProductList.products += newProduct
        Created(Json.toJson(newProduct))
      }
    )
  }

  // PUT /products/:id
  def updateProduct(id: Int): Action[JsValue] = Action(parse.json) { implicit request =>
    request.body.validate[Product].fold(
      errors => BadRequest(Json.obj("error" -> JsError.toJson(errors))),
      updatedProduct => {
        ProductList.products.indexWhere(_.id == id) match {
          case -1 =>
            NotFound(Json.obj("error" -> "Product not found"))
          case index =>
            ProductList.products.update(index, updatedProduct.copy(id = id))
            Ok(Json.toJson(updatedProduct))
        }
      }
    )
  }

  // DELETE /products/:id
  def deleteProduct(id: Int): Action[AnyContent] = Action { implicit request =>
    ProductList.products.indexWhere(_.id == id) match {
      case -1 =>
        NotFound(Json.obj("error" -> "Product not found"))
      case index =>
        ProductList.products.remove(index)
        Ok(Json.obj("message" -> "Product deleted successfully"))
    }
  }
}



@Singleton
class CategoryController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  implicit val categoryWrites: Writes[Category] = Json.writes[Category]
  implicit val categoryReads: Reads[Category] = (
    (JsPath \ "id").read[Int] and
    (JsPath \ "name").read[String]
  )(Category.apply _)

  // GET /categories
  def getAllCategories: Action[AnyContent] = Action {
    Ok(Json.toJson(CategoryList.categories.toList))
  }

  // GET /categories/:id
  def getCategoryById(id: Int): Action[AnyContent] = Action { implicit request =>
    CategoryList.categories.find(_.id == id) match {
      case Some(category) => Ok(Json.toJson(category))
      case None => NotFound(Json.obj("error" -> "Category not found"))
    }
  }

  // POST /categories
  def createCategory: Action[JsValue] = Action(parse.json) { implicit request =>
    request.body.validate[Category].fold(
      errors => BadRequest(Json.obj("error" -> JsError.toJson(errors))),
      category => {
        val newCategoryId = if (CategoryList.categories.isEmpty) 1 else CategoryList.categories.map(_.id).max + 1 
        val newCategory = category.copy(id = newCategoryId)
        CategoryList.categories += newCategory
        Created(Json.toJson(newCategory))
      }
    )
  }

  // PUT /categories/:id
  def updateCategory(id: Int): Action[JsValue] = Action(parse.json) { implicit request =>
    request.body.validate[Category].fold(
      errors => BadRequest(Json.obj("error" -> JsError.toJson(errors))),
      updatedCategory => {
        CategoryList.categories.indexWhere(_.id == id) match {
          case -1 =>
            NotFound(Json.obj("error" -> "Category not found"))
          case index =>
            CategoryList.categories.update(index, updatedCategory.copy(id = id))
            Ok(Json.toJson(updatedCategory))
        }
      }
    )
  }

  // DELETE /categories/:id
  def deleteCategory(id: Int): Action[AnyContent] = Action { implicit request =>
    CategoryList.categories.indexWhere(_.id == id) match {
      case -1 =>
        NotFound(Json.obj("error" -> "Category not found"))
      case index =>
        CategoryList.categories.remove(index)
        Ok(Json.obj("message" -> "Category deleted successfully"))
    }
  }
}
