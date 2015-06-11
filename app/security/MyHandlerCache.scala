package security

import javax.inject.Singleton

import be.objectify.deadbolt.scala.{HandlerKey, DeadboltHandler}
import be.objectify.deadbolt.scala.cache.HandlerCache

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
@Singleton
class MyHandlerCache extends HandlerCache {

  val defaultHandler: DeadboltHandler = new MyDeadboltHandler

  val handlers: Map[Any, DeadboltHandler] = Map(HandlerKeys.defaultHandler -> defaultHandler,
                                                HandlerKeys.altHandler -> new MyDeadboltHandler(Some(MyAlternativeDynamicResourceHandler)),
                                                HandlerKeys.userlessHandler -> new MyUserlessDeadboltHandler)

  override def apply(): DeadboltHandler = defaultHandler

  override def apply(handlerKey: HandlerKey): DeadboltHandler = handlers(handlerKey)
}
