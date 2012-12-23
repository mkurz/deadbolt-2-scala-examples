package security

import be.objectify.deadbolt.scala.{DynamicResourceHandler, DeadboltHandler}
import play.api.mvc.{Request, Result, Results}
import be.objectify.deadbolt.core.models.Subject
import models.User

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

  def onAccessFailure[A](request: Request[A]): Result = {
    Results.Forbidden(views.html.accessFailed())
  }
}