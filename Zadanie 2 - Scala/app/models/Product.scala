package models

import scala.collection.mutable.ListBuffer


case class Product(id: Int, name: String, price: Double, category: String)

object ProductList {
  // Sample product list
  val products: ListBuffer[Product] = ListBuffer(
    Product(1, "Smartphone", 599.99, "Electronics"),
    Product(2, "Laptop", 999.99, "Electronics"),
    Product(3, "Headphones", 149.99, "Electronics"),
    Product(4, "Tablet", 399.99, "Electronics"),
    Product(5, "Smart Watch", 199.99, "Electronics"),
    Product(6, "Digital Camera", 449.99, "Electronics"),
    Product(7, "Bluetooth Speaker", 79.99, "Electronics"),
    Product(8, "Gaming Console", 499.99, "Electronics"),
    Product(9, "Wireless Earbuds", 129.99, "Electronics"),
    Product(10, "External Hard Drive", 79.99, "Electronics"),
    Product(11, "Running Shoes", 89.99, "Sports"),
    Product(12, "Yoga Mat", 29.99, "Sports"),
    Product(13, "Dumbbells", 49.99, "Sports"),
    Product(14, "Tennis Racket", 79.99, "Sports"),
    Product(15, "Soccer Ball", 19.99, "Sports"),
    Product(16, "Bicycle", 399.99, "Sports"),
    Product(17, "Treadmill", 799.99, "Sports"),
    Product(18, "Golf Clubs Set", 299.99, "Sports"),
    Product(19, "Swimming Goggles", 39.99, "Sports"),
    Product(20, "Basketball Hoop", 199.99, "Sports"),
    Product(21, "Frying Pan", 39.99, "Kitchen"),
    Product(22, "Coffee Maker", 149.99, "Kitchen"),
    Product(23, "Blender", 69.99, "Kitchen"),
    Product(24, "Toaster", 29.99, "Kitchen"),
    Product(25, "Cutlery Set", 49.99, "Kitchen"),
    Product(26, "Food Processor", 99.99, "Kitchen"),
    Product(27, "Microwave Oven", 149.99, "Kitchen"),
    Product(28, "Slow Cooker", 79.99, "Kitchen"),
    Product(29, "Electric Kettle", 34.99, "Kitchen"),
    Product(30, "Stand Mixer", 249.99, "Kitchen")
  )

  var categoriesSet: Set[String] = products.map(_.category).toSet
}
