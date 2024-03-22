package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class CartController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // GET /cart
  def getCart: Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // POST /cart/add/:productId
  def addToCart(productId: Int): Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // POST /cart/remove/:productId
  def removeFromCart(productId: Int): Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // POST /cart/checkout
  def checkout: Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }
}
