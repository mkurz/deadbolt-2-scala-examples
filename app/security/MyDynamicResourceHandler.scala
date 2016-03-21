package security

import be.objectify.deadbolt.scala.{AuthenticatedRequest, DynamicResourceHandler, DeadboltHandler}
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
  override def isAllowed[A](name: String, meta: Option[Any], handler: DeadboltHandler, request: AuthenticatedRequest[A]): Future[Boolean] = {
    MyDynamicResourceHandler.handlers(name).isAllowed(name,
                                                      meta,
                                                      handler,
                                                      request)
  }

  // todo implement this when demonstrating permissions
  override def checkPermission[A](permissionValue: String, meta: Option[Any] = None, deadboltHandler: DeadboltHandler, request: AuthenticatedRequest[A]): Future[Boolean] = Future(false)
}

object MyDynamicResourceHandler {
  val handlers: Map[String, DynamicResourceHandler] =
    Map(
         "pureLuck" -> new DynamicResourceHandler() {
           override def isAllowed[A](name: String, meta: Option[Any], deadboltHandler: DeadboltHandler, request: AuthenticatedRequest[A]): Future[Boolean] =
             Future(System.currentTimeMillis() % 2 == 0)

           override def checkPermission[A](permissionValue: String, meta: Option[Any] = None, deadboltHandler: DeadboltHandler, request: AuthenticatedRequest[A]): Future[Boolean] = Future(false)
         }
       )
}