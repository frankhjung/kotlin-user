package console

import data.insertUser
import kotlin.system.exitProcess
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required
import mu.KotlinLogging

/**
 * Create a userid from a username. This writes the username to a database and returns the created
 * user id.
 * @param args command line arguments
 */
fun main(args: Array<String>): Unit {
  val parser = ArgParser("CreateUser")
  val username by parser
      .option(ArgType.String, shortName = "u", description = "Username")
      .required()
  val verbose by parser
      .option(ArgType.Boolean, shortName = "v", description = "Turn on verbose mode")
      .default(false)

  parser.parse(args)

  val logger = KotlinLogging.logger {}
  logger.debug("Creating user $username")
  val user = insertUser(username)
  logger.debug("Created user ${user.name} with id ${user.id}")

  exitProcess(0)
}
