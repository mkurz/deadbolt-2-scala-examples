package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.{Action, Controller}
import security.MyDeadboltHandler
import views.html.accessOk

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class RestrictController @Inject() (deadbolt: DeadboltActions, actionBuilder: ActionBuilders) extends Controller
{
  def index = Action {
                Ok(accessOk())
              }

  def restrictOne = deadbolt.Restrict(List(Array("foo"))) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def restrictTwo = deadbolt.Restrict(List(Array("foo", "bar"))) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def restrictThree = deadbolt.Restrict(List(Array("foo", "!bar"))) {
                        Action {
                          Ok(accessOk())
                        }
                      }

  def restrictFour = deadbolt.Restrict(List(Array("hurdy"))) {
                       Action {
                         Ok(accessOk())
                       }
                                                             }
  def restrictOr = deadbolt.Restrict(List(Array("foo"), Array("hurdy"))) {
                       Action {
                         Ok(accessOk())
                       }
                                                             }

  def restrictOne_fromBuilder = actionBuilder.RestrictAction("foo").defaultHandler() { Ok(accessOk()) }

  def restrictTwo_fromBuilder = actionBuilder.RestrictAction("foo", "bar").defaultHandler() { Ok(accessOk()) }

  def restrictThree_fromBuilder = actionBuilder.RestrictAction("foo", "!bar").defaultHandler() { Ok(accessOk()) }

  def restrictFour_fromBuilder = actionBuilder.RestrictAction("hurdy").defaultHandler() { Ok(accessOk()) }

  def restrictOr_fromBuilder = actionBuilder.RestrictAction(List(Array("foo"), Array("hurdy"))).defaultHandler() { Ok(accessOk()) }
}