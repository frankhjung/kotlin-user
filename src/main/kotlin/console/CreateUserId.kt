package console

import data.User
import data.addUser
import java.util.function.Consumer
import kotlin.system.exitProcess
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required

val logger = mu.KotlinLogging.logger {}

/**
 * Create a userid from a username. This writes the username to a database and returns the created
 * user id.
 * @param args command line arguments
 */
fun main(args: Array<String>) {
  val parser = ArgParser("CreateUser")
  val username by parser
      .option(ArgType.String, shortName = "u", description = "Username")
      .required()

  // get username from commandline argument
  parser.parse(args)

  logger.info("Creating user $username ...")
  val users: List<User> = addUser(username)
  users.forEach(Consumer { u: User -> logger.info("Created user ${u.name} with id ${u.id}\n") })

  exitProcess(0)
}
