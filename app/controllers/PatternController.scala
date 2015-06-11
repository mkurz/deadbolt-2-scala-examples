package controllers

import javax.inject.Inject

import be.objectify.deadbolt.core.PatternType
import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.{Action, Controller}
import views.html.accessOk

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class PatternController @Inject() (deadbolt: DeadboltActions, actionBuilders: ActionBuilders) extends Controller
{
  def printersEdit = deadbolt.Pattern("printers.edit", PatternType.EQUALITY) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def printersFoo = deadbolt.Pattern("printers.foo", PatternType.EQUALITY) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def printersRegex = deadbolt.Pattern("(.)*\\.edit", PatternType.REGEX) {
                   Action {
                     Ok(accessOk())
                   }
                 }

  def printersEdit_fromBuilder = actionBuilders.PatternAction("printers.edit", PatternType.EQUALITY).defaultHandler() { Ok(accessOk()) }

  def printersFoo_fromBuilder = actionBuilders.PatternAction("printers.foo", PatternType.EQUALITY).defaultHandler() { Ok(accessOk()) }

  def printersRegex_fromBuilder = actionBuilders.PatternAction("(.)*\\.edit", PatternType.REGEX).defaultHandler() { Ok(accessOk()) }
}
