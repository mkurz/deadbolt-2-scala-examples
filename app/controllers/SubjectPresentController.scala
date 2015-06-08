package controllers

import javax.inject.Inject

import views.html.accessOk
import play.api.mvc.{Action, Controller}
import security.{MyUserlessDeadboltHandler, MyDeadboltHandler}
import be.objectify.deadbolt.scala.DeadboltActions

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class SubjectPresentController @Inject() (deadbolt: DeadboltActions) extends Controller {

  def loggedIn = deadbolt.SubjectPresent(new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def notLoggedIn = deadbolt.SubjectPresent(new MyUserlessDeadboltHandler) {
                      Action {
                        Ok(accessOk())
                      }
                    }
}