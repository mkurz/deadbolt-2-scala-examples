package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import be.objectify.deadbolt.scala.cache.HandlerCache
import play.api.mvc.{Action, Controller}
import security.{HandlerKeys, MyAlternativeDynamicResourceHandler, MyDeadboltHandler}
import views.html.accessOk

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class DynamicRestrictionsController @Inject() (deadbolt: DeadboltActions, handlers: HandlerCache, actionBuilder: ActionBuilders) extends Controller
{
  def pureLuck = deadbolt.Dynamic(name = "pureLuck") {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def noWayJose = deadbolt.Dynamic(name = "pureLuck", handler= handlers(HandlerKeys.altHandler)) {
                    Action {
                      Ok(accessOk())
                    }
                  }

  def pureLuck_fromBuilder = actionBuilder.DynamicAction(name = "pureLuck").defaultHandler() {
                                                                                               Ok(accessOk())
                                                                                             }

  def noWayJose_fromBuilder = actionBuilder.DynamicAction(name = "pureLuck").key(HandlerKeys.altHandler) {
                                                                                                           Ok(accessOk())
                                                                                                         }
}
