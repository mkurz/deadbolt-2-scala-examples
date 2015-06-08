package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}
import views.html.accessOk
import security.{MyAlternativeDynamicResourceHandler, MyDeadboltHandler}
import be.objectify.deadbolt.scala.DeadboltActions

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class DynamicRestrictionsController @Inject() (deadbolt: DeadboltActions) extends Controller
{
  def pureLuck = deadbolt.Dynamic("pureLuck", "", new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def noWayJose = deadbolt.Dynamic("pureLuck", "", new MyDeadboltHandler(Some(MyAlternativeDynamicResourceHandler))) {
                    Action {
                      Ok(accessOk())
                    }
                  }
}
