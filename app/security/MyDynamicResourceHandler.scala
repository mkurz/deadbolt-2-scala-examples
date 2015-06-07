package security

import be.objectify.deadbolt.scala.{DynamicResourceHandler, DeadboltHandler}
import collection.immutable.Map
import play.api.mvc.Request

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class MyDynamicResourceHandler extends DynamicResourceHandler
{
  def isAllowed[A](name: String, meta: String, handler: DeadboltHandler, request: Request[A]): Future[Boolean] = {
    MyDynamicResourceHandler.handlers(name).isAllowed(name,
                                                      meta,
                                                      handler,
                                                      request)
  }

  // todo implement this when demonstrating permissions
  def checkPermission[A](permissionValue: String, deadboltHandler: DeadboltHandler, request: Request[A]): Future[Boolean] = Future(false)
}

object MyDynamicResourceHandler {
  val handlers: Map[String, DynamicResourceHandler] =
    Map(
         "pureLuck" -> new DynamicResourceHandler() {
           def isAllowed[A](name: String, meta: String, deadboltHandler: DeadboltHandler, request: Request[A]): Future[Boolean] =
             Future(System.currentTimeMillis() % 2 == 0)

           def checkPermission[A](permissionValue: String, deadboltHandler: DeadboltHandler, request: Request[A]): Future[Boolean] = Future(false)
         }
       )
}