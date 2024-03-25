package models

import scala.collection.mutable.ListBuffer


case class Cart(products: ListBuffer[Product])

object Cart {
  var cart: Cart = Cart(ListBuffer.empty[Product])

}

