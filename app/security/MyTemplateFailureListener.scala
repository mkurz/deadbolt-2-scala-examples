package security

import javax.inject.Singleton

import be.objectify.deadbolt.scala.TemplateFailureListener
import play.api.Logger

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
@Singleton
class MyTemplateFailureListener extends TemplateFailureListener {

  val logger = Logger("example-app.deadbolt")

  logger.info("Template failure listener ready to rock")

  override def failure(message: String, timeout: Long): Unit = logger.error(s"We need to do something about this, because [$message] occurred after [$timeout]ms")

}
