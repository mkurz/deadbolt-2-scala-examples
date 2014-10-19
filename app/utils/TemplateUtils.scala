package utils

import be.objectify.deadbolt.core.models.Subject
import be.objectify.deadbolt.scala.DeadboltHandler
import play.api.mvc.Request
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, duration}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
object TemplateUtils {

  def getSubjectNow(deadboltHandler: DeadboltHandler,
                    request: Request[Any]): Option[Subject] = {
    Await.result(deadboltHandler.getSubject(request).flatMap(subjectOption => subjectOption match {
      case Some(subject) => Future(Some(subject))
      case None => Future(None)
    }), Duration(1000, duration.MILLISECONDS))
  }
}
