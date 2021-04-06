package console

import data.User
import data.insertUser
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required
import mu.KotlinLogging
import kotlin.system.exitProcess

internal val logger = KotlinLogging.logger {}

/**
 * Create a userid from a username.
 * This writes the username to a database and returns the created user id.
 * @param args command line arguments
 */
fun main(args: Array<String>) {
    val parser = ArgParser("CreateUser")
    val username by parser.option(ArgType.String, shortName = "u", description = "Username").required()
    val verbose by parser.option(ArgType.Boolean, shortName = "v", description = "Turn on verbose mode").default(false)

    parser.parse(args)

    if (verbose) {
        val message = "Creating id for user $username"
        println(message)
        logger.debug(message)
    }
    // call repository functions to insert user
    val user = User(name = username)
    insertUser(user)

    exitProcess(0)
}
