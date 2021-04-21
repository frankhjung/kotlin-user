package console

import data.User
import data.addUsers
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.vararg
import mu.KotlinLogging
import java.util.function.Consumer
import kotlin.system.exitProcess

/** Logger for project. */
private val logger = KotlinLogging.logger {}

/**
 * Create a userid from a username. This writes the username to a database and returns the created
 * user id.
 * @param args command line arguments
 */
fun main(args: Array<String>) {

  // define parser
  val parser = ArgParser("CreateUserIds")
  val usernames by parser.argument(ArgType.String, description = "username1 username2 ...").vararg()

  // get username from commandline argument
  parser.parse(args)

  // process list (could be empty) of users to create
  val users = addUsers(usernames)
  users.forEach(Consumer { u: User -> logger.info("Created user \"${u.name}\" with id ${u.id}") })

  exitProcess(0)
}