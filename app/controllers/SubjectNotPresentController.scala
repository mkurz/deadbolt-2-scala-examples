package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import be.objectify.deadbolt.scala.cache.HandlerCache
import play.api.mvc.{Action, Controller}
import security.HandlerKeys
import views.html.accessOk

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class SubjectNotPresentController @Inject() (deadbolt: DeadboltActions, handlers: HandlerCache, actionBuilder: ActionBuilders) extends Controller
{
  def loggedIn = deadbolt.SubjectNotPresent() {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def notLoggedIn = deadbolt.SubjectNotPresent(handlers(HandlerKeys.userlessHandler)) {
                      Action {
                        Ok(accessOk())
                      }
                    }

  def loggedIn_withBuilder = actionBuilder.SubjectNotPresentAction().defaultHandler() {
      Ok(accessOk())
  }

  def notLoggedIn_withBuilder = actionBuilder.SubjectNotPresentAction().key(HandlerKeys.userlessHandler) {
      Ok(accessOk())
  }
}