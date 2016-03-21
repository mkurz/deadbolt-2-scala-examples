package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.DeadboltActions
import play.api.mvc.Controller
import security.MyDeadboltHandler

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class Application @Inject()(deadbolt: DeadboltActions) extends Controller {
  def index = deadbolt.WithAuthRequest()() { authRequest =>
    Future {
             Ok(views.html.index(new MyDeadboltHandler)(authRequest))
           }
                                           }
}