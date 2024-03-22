package models

import play.api.libs.json.Json

case class Product(id: Int, name: String, price: Double, category: String)

object Product {
  // Definiowanie formatu JSON dla modelu Product
  implicit val productFormat = Json.format[Product]
}
