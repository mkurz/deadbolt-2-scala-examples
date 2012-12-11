package controllers

import views.html.accessOk
import play.api.mvc.{Action, Controller}
import security.MyUserlessDeadboltHandler
import security.{MyUserlessDeadboltHandler, MyDeadboltHandler}
import be.objectify.deadbolt.scala.DeadboltActions

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
object SubjectPresentController extends Controller with DeadboltActions
{

  def loggedIn = SubjectPresent(new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def notLoggedIn = SubjectPresent(new MyUserlessDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }
}