package models

case class Cart(userId: Int, items: Map[Product, Int])
