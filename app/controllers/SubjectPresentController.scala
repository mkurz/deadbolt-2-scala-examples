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
class SubjectPresentController @Inject()(deadbolt: DeadboltActions, handlers: HandlerCache, actionBuilder: ActionBuilders) extends Controller {

  def loggedIn = deadbolt.SubjectPresent()() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                             }

  def notLoggedIn = deadbolt.SubjectPresent(handlers(HandlerKeys.userlessHandler))() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                     }

  def loggedIn_fromBuilder = actionBuilder.SubjectPresentAction().defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                   }

  def notLoggedIn_fromBuilder = actionBuilder.SubjectPresentAction().key(HandlerKeys.userlessHandler) { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                      }
}