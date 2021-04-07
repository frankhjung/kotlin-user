package data

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

// val dbconn : Connection = DriverManager.getConnection("jdbc:h2:mem:", "admin", "password")

/** User Data Access Object. */
fun insertUser(name: String): User {
  logger.debug { "Inserting user $name" }
  return User(0, name) // return the user id
}

fun createDB() {}

fun getByName(name: String): User {
  return User(0, name)
}
