package modules

import be.objectify.deadbolt.scala.{DeadboltExecutionContextProvider, TemplateFailureListener}
import be.objectify.deadbolt.scala.cache.HandlerCache
import play.api.inject.{Binding, Module}
import play.api.{Configuration, Environment}
import security.{CustomDeadboltExecutionContextProvider, MyHandlerCache, MyCustomTemplateFailureListener}

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
class CustomDeadboltHook extends Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    bind[TemplateFailureListener].to[MyCustomTemplateFailureListener],
    bind[HandlerCache].to[MyHandlerCache],
    bind[DeadboltExecutionContextProvider].to[CustomDeadboltExecutionContextProvider]
  )
}
