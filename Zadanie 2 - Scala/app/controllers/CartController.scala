package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import scala.collection.mutable.ListBuffer
import play.api.libs.json._
import play.api.libs.functional.syntax._
import models.{Cart, Product, Category, CategoryList, ProductList}


// -------------CartController------------------------

@Singleton
class CartController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  implicit val productWrites: Writes[Product] = Json.writes[Product]

  // GET /cart
  def getCart: Action[AnyContent] = Action {
    Ok(Json.toJson(Cart.cart.products.toList))
  }

  // POST /cart/:productId
  def addToCart(productId: Int): Action[AnyContent] = Action { implicit request =>
    ProductList.products.find(_.id == productId) match {
      case Some(product) =>
        Cart.cart.products += product
        Ok(Json.toJson(Cart.cart.products.toList))
      case None =>
        NotFound(Json.obj("error" -> "Product not found"))
    }
  }

  // DELETE /cart/:productId
  def removeFromCart(productId: Int): Action[AnyContent] = Action { implicit request =>
    val index = Cart.cart.products.indexWhere(_.id == productId)
    if (index != -1) {
      Cart.cart.products.remove(index)
      Ok(Json.obj("message" -> "Product removed from cart"))
    } else {
      NotFound(Json.obj("error" -> "Product not found in cart"))
    }
  }

}

