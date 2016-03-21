package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.{Action, Controller}
import views.html.accessOk

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  *
  * @author Steve Chaloner (steve@objectify.be)
  */
class RestrictController @Inject()(deadbolt: DeadboltActions, actionBuilder: ActionBuilders) extends Controller {
  def index = Action {
                       Ok(accessOk())
                     }

  def restrictOne = deadbolt.Restrict(List(Array("foo")))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                            }

  def restrictTwo = deadbolt.Restrict(List(Array("foo", "bar")))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                   }

  def restrictThree = deadbolt.Restrict(List(Array("foo", "!bar")))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                      }

  def restrictFour = deadbolt.Restrict(List(Array("hurdy")))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                               }

  def restrictOr = deadbolt.Restrict(List(Array("foo"), Array("hurdy")))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                           }

  def restrictOne_fromBuilder = actionBuilder.RestrictAction("foo").defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                     }

  def restrictTwo_fromBuilder = actionBuilder.RestrictAction("foo", "bar").defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                            }

  def restrictThree_fromBuilder = actionBuilder.RestrictAction("foo", "!bar").defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                               }

  def restrictFour_fromBuilder = actionBuilder.RestrictAction("hurdy").defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                        }

  def restrictOr_fromBuilder = actionBuilder.RestrictAction(List(Array("foo"), Array("hurdy"))).defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                                 }
}