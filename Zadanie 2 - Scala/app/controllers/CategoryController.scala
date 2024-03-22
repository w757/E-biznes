package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class CategoryController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // GET /categories
  def getAllCategories: Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // GET /categories/:id
  def getCategoryById(id: Int): Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // POST /categories
  def createCategory: Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // PUT /categories/:id
  def updateCategory(id: Int): Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }

  // DELETE /categories/:id
  def deleteCategory(id: Int): Action[AnyContent] = Action {
    NotImplemented // Implement as needed
  }
}
