package data

import mu.KotlinLogging
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

private val logger = KotlinLogging.logger {}

val sessionFactory: SessionFactory = getSessionFactoryFromConfig()

/**
 * Get session factory from hibernate configuration.
 * @return SessionFactory the session factory
 */
fun getSessionFactoryFromConfig(): SessionFactory {
  val config = Configuration().configure()
  return config.buildSessionFactory()
}

/**
 * Add a user to h2 database by name.
 * @param usernames the user to add
 * @return List<User> a list of users that were persisted or an empty list
 */
fun addUsers(usernames: List<String>): List<User> {
  return if (usernames.isNotEmpty()) {
    addAllUsers(usernames)
  } else {
    logger.warn("No users to add. Ignoring.")
    emptyList()
  }
}

/**
 * Only add uses for non-empty list
 * @param usernames the non-empty list of users to add
 * @return List<User> the list of user objects that were persisted
 */
private fun addAllUsers(usernames: List<String>): List<User> {
  return sessionFactory.use { factory ->
    val session = factory.openSession()
    session.beginTransaction()
    usernames.forEach { username ->
      logger.info("Adding user $username ...")
      saveUser(session, username)
    }
    val users = getUsers(session)
    session.transaction.commit()
    session.close()
    users
  }
}

/**
 * Save username to database.
 * @param session the open session to use
 * @param username the username to persist to database
 */
fun saveUser(session: Session, username: String) {
  val user = User(username)
  session.apply { this.persist(user) }
}

/** Convert typed list. If not values, return an empty list rather than a null. */
@Suppress("UNCHECKED_CAST")
private inline fun <reified T> List<*>.asListOfType(): List<T> =
    if (all { it is T }) this as List<T> else emptyList()

/**
 * Get a list of all users from the database.
 * @param session the open session to use
 * @return List<User> a list of users or an empty list if none found
 */
fun getUsers(session: Session): List<User> {
  val results = session.createQuery("FROM user").list()
  return results.asListOfType()
}
