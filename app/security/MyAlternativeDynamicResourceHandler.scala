package security

import play.api.mvc.Request
import be.objectify.deadbolt.scala.{DeadboltHandler, DynamicResourceHandler}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */

object MyAlternativeDynamicResourceHandler extends DynamicResourceHandler {
  def isAllowed[A](name: String,
                   meta: String,
                   handler: DeadboltHandler,
                   request: Request[A]): Future[Boolean] = Future(false)

  def checkPermission[A](permissionValue: String,
                         deadboltHandler: DeadboltHandler,
                         request: Request[A]): Future[Boolean] = Future(false)
}