package controllers

import views.html.accessOk
import play.api.mvc.{Action, Controller}
import security.{MyUserlessDeadboltHandler, MyDeadboltHandler}
import be.objectify.deadbolt.scala.DeadboltActions

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
object SubjectNotPresentController extends Controller with DeadboltActions
{

  def loggedIn = SubjectNotPresent(new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def notLoggedIn = SubjectNotPresent(new MyUserlessDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }
}