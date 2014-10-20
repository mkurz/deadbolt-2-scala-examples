package security

import be.objectify.deadbolt.scala.DeadboltHandler

object DeadboltHandlers {
  implicit val defaultHandler: DeadboltHandler = new MyDeadboltHandler()
}