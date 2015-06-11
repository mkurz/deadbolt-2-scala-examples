package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.cache.HandlerCache
import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.{Action, Controller}
import security.HandlerKeys
import views.html.accessOk

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class SubjectPresentController @Inject()(deadbolt: DeadboltActions, handlers: HandlerCache, actionBuilder: ActionBuilders) extends Controller {

  def loggedIn = deadbolt.SubjectPresent() {
                                             Action {
                                                      Ok(accessOk())
                                                    }
                                           }

  def notLoggedIn = deadbolt.SubjectPresent(handlers(HandlerKeys.userlessHandler)) {
                                                                                     Action {
                                                                                              Ok(accessOk())
                                                                                            }
                                                                                   }

  def loggedIn_fromBuilder = actionBuilder.SubjectPresentAction().defaultHandler() {
                                                                                     Ok(accessOk())
                                                                                   }

  def notLoggedIn_fromBuilder = actionBuilder.SubjectPresentAction().key(HandlerKeys.userlessHandler) {
                                                                                                        Ok(accessOk())
                                                                                                      }
}