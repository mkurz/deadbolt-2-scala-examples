package controllers

import be.objectify.deadbolt.scala.DeadboltActionBuilders._
import be.objectify.deadbolt.scala.DeadboltHandler
import views.html.accessOk
import play.api.mvc.{Action, Controller}
import security.MyDeadboltHandler

import security.DeadboltHandlers.defaultHandler

object RestrictActionController extends Controller {

    def index = Action {
      Ok(accessOk())
    }

    def restrictOne = RestrictAction("foo") {
      Ok(accessOk())
    }

    // passing handler explicitly
    def restrictTwo = RestrictAction("foo", "bar").withHandler(security.DeadboltHandlers.defaultHandler) {
      Ok(accessOk())
    }

    def restrictThree = RestrictAction("foo", "!bar") {
      Ok(accessOk())
    }
    
    def restrictFour = RestrictAction("hurdy") {
      Ok(accessOk())
    }

}
