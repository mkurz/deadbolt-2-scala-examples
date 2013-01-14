package controllers

import views.html.accessOk
import play.api.mvc.{Action, Controller}
import security.MyDeadboltHandler
import be.objectify.deadbolt.scala.DeadboltActions

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
object RestrictController extends Controller with DeadboltActions
{
  def index = Action {
                Ok(accessOk())
              }

  def restrictOne = Restrictions(Array("foo"), new MyDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def restrictTwo = Restrictions(Array("foo", "bar"), new MyDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def restrictThree = Restrictions(Array("foo", "!bar"), new MyDeadboltHandler) {
                        Action {
                          Ok(accessOk())
                        }
                      }

  def restrictFour = Restrictions(Array("hurdy"), new MyDeadboltHandler) {
                       Action {
                         Ok(accessOk())
                       }
                     }
}