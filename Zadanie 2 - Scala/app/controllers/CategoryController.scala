package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import scala.collection.mutable.ListBuffer
import play.api.libs.json._
import play.api.libs.functional.syntax._
import models.{Cart, Product, Category, CategoryList, ProductList}


// -------------CategoryController------------------------

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


