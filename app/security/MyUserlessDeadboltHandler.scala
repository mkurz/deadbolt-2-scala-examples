package security

import be.objectify.deadbolt.scala.DynamicResourceHandler
import play.api.mvc.Request
import be.objectify.deadbolt.core.models.Subject

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class MyUserlessDeadboltHandler(dynamicResourceHandler: Option[DynamicResourceHandler] = None) extends MyDeadboltHandler
{
  override def getSubject[A](request: Request[A]): Future[Option[Subject]] = Future(None)
}