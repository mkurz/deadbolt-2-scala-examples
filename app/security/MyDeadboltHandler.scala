package security

import be.objectify.deadbolt.scala.{DynamicResourceHandler, DeadboltHandler}
import play.api.mvc.{Request, Result, Results}
import be.objectify.deadbolt.core.models.Subject
import models.User
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class MyDeadboltHandler(dynamicResourceHandler: Option[DynamicResourceHandler] = None) extends DeadboltHandler {

  def beforeAuthCheck[A](request: Request[A]) = None

  override def getDynamicResourceHandler[A](request: Request[A]): Option[DynamicResourceHandler] = {
    if (dynamicResourceHandler.isDefined) dynamicResourceHandler
    else Some(new MyDynamicResourceHandler())
  }

  override def getSubject[A](request: Request[A]): Option[Subject] = {
    // e.g. request.session.get("user")
    Some(new User("steve"))
  }

  def onAuthFailure[A](request: Request[A]): Future[Result] = {
    Future {Results.Forbidden(views.html.accessFailed())}
  }
}