package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import scala.collection.mutable.ListBuffer
import play.api.libs.json._
import play.api.libs.functional.syntax._
import models.{Cart, Product, Category, CategoryList, ProductList}




// -------------ProductController------------------------

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


