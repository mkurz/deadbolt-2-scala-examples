package models

import be.objectify.deadbolt.scala.models.Permission

/**
 *
 * @author Steve Chaloner (steve@objectify.be)
 */

case class UserPermission(value: String) extends Permission
