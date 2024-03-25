package models

import scala.collection.mutable.ListBuffer

case class Category(id: Int, name: String)

object CategoryList {
  // Sample category list
  val categories: ListBuffer[Category] = ListBuffer(
    Category(1, "Electronics"),
    Category(2, "Clothing")
  )
}
