package controllers

import javax.inject.Inject

import views.html.accessOk
import play.api.mvc.{Action, Controller}
import security.MyDeadboltHandler
import be.objectify.deadbolt.scala.DeadboltActions

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class RestrictController @Inject() (deadbolt: DeadboltActions) extends Controller
{
  def index = Action {
                Ok(accessOk())
              }

  def restrictOne = deadbolt.Restrict(Array("foo"), new MyDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def restrictTwo = deadbolt.Restrict(Array("foo", "bar"), new MyDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def restrictThree = deadbolt.Restrict(Array("foo", "!bar"), new MyDeadboltHandler) {
                        Action {
                          Ok(accessOk())
                        }
                      }

  def restrictFour = deadbolt.Restrict(Array("hurdy"), new MyDeadboltHandler) {
                       Action {
                         Ok(accessOk())
                       }
                     }
}