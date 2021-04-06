package data

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

/**
 * User Data Access Object.
 */

fun insertUser(user: User): Int {
    logger.debug { "inserting user ${user.id}" }
    return 0 // return the user id
}

fun createDB() {
}
