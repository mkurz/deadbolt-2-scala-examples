package modules

import be.objectify.deadbolt.scala.TemplateFailureListener
import be.objectify.deadbolt.scala.cache.HandlerCache
import play.api.inject.{Binding, Module}
import play.api.{Configuration, Environment}
import security.{MyHandlerCache, MyCustomTemplateFailureListener}

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
class CustomDeadboltHook extends Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    bind[TemplateFailureListener].to[MyCustomTemplateFailureListener],
    bind[HandlerCache].to[MyHandlerCache]
  )
}
