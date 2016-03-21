package utils

import be.objectify.deadbolt.scala.models.Subject
import be.objectify.deadbolt.scala.{AuthenticatedRequest, DeadboltHandler}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, duration}

/**
  * @author Steve Chaloner (steve@objectify.be)
  */
object TemplateUtils {

  def getSubjectNow(deadboltHandler: DeadboltHandler,
                    request: AuthenticatedRequest[Any]): Option[Subject] = {
    Await.result(deadboltHandler.getSubject(request).flatMap {
                                                               case Some(subject) => Future(Some(subject))
                                                               case None => Future(None)
                                                             }, Duration(1000, duration.MILLISECONDS))
  }
}
