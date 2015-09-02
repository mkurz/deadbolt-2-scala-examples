package security

import be.objectify.deadbolt.scala.DeadboltExecutionContextProvider

import scala.concurrent.ExecutionContext

/**
 * A custom execution context can be provided to Deadbolt for asynchronous operations.
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
class CustomDeadboltExecutionContextProvider extends DeadboltExecutionContextProvider {
  override def get(): ExecutionContext = scala.concurrent.ExecutionContext.global
}
