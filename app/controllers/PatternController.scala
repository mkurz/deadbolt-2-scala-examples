package controllers

import javax.inject.Inject

import be.objectify.deadbolt.scala.models.PatternType
import be.objectify.deadbolt.scala.{ActionBuilders, DeadboltActions}
import play.api.mvc.Controller
import views.html.accessOk

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  *
  * @author Steve Chaloner (steve@objectify.be)
  */
class PatternController @Inject()(deadbolt: DeadboltActions, actionBuilders: ActionBuilders) extends Controller {
  def printersEdit = deadbolt.Pattern("printers.edit", PatternType.EQUALITY)() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                               }

  def printersFoo = deadbolt.Pattern("printers.foo", PatternType.EQUALITY)() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                             }

  def printersRegex = deadbolt.Pattern("(.)*\\.edit", PatternType.REGEX)() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                           }

  def printersEdit_fromBuilder = actionBuilders.PatternAction("printers.edit", PatternType.EQUALITY).defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                                      }

  def printersFoo_fromBuilder = actionBuilders.PatternAction("printers.foo", PatternType.EQUALITY).defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                                    }

  def printersRegex_fromBuilder = actionBuilders.PatternAction("(.)*\\.edit", PatternType.REGEX).defaultHandler() { authRequest =>
    Future {
             Ok(accessOk())
           }
                                                                                                                  }
}
