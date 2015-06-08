package controllers

import play.api.mvc.{Action, Controller}
import security.MyDeadboltHandler

class Application extends Controller
{
  def index = Action {
                implicit request =>
                Ok(views.html.index(new MyDeadboltHandler))
              }
}