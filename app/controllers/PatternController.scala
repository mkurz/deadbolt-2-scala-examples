package controllers

import javax.inject.Inject

import security.MyDeadboltHandler
import play.api.mvc.{Action, Controller}
import views.html.accessOk
import be.objectify.deadbolt.scala.DeadboltActions
import be.objectify.deadbolt.core.PatternType

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class PatternController @Inject() (deadbolt: DeadboltActions)extends Controller
{
  def printersEdit = deadbolt.Pattern("printers.edit", PatternType.EQUALITY, new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def printersFoo = deadbolt.Pattern("printers.foo", PatternType.EQUALITY, new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def printersRegex = deadbolt.Pattern("(.)*\\.edit", PatternType.REGEX, new MyDeadboltHandler) {
                   Action {
                     Ok(accessOk())
                   }
                 }
}
