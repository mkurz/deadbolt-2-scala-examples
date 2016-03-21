package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.cache.HandlerCache
import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.Controller
import security.HandlerKeys
import views.html.accessOk

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  *
  * @author Steve Chaloner (steve@objectify.be)
  */
class SubjectNotPresentController @Inject()(deadbolt: DeadboltActions, handlers: HandlerCache, actionBuilder: ActionBuilders) extends Controller {
  def loggedIn = deadbolt.SubjectNotPresent()() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                }

  def notLoggedIn = deadbolt.SubjectNotPresent(handlers(HandlerKeys.userlessHandler))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                        }

  def loggedIn_withBuilder = actionBuilder.SubjectNotPresentAction().defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                      }

  def notLoggedIn_withBuilder = actionBuilder.SubjectNotPresentAction().key(HandlerKeys.userlessHandler) { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                         }
}