package data

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

val logger = mu.KotlinLogging.logger {}

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
 * @param username the user to add
 * @return List<User> a list of users
 */
fun addUser(username: String): List<User> {
  sessionFactory.use { factory ->
    val session = factory.openSession()
    session.beginTransaction()
    saveUser(session, username)
    session.transaction.commit()
    val users = getUsers(session)
    session.close()
    return users
  }
}

/**
 * Save username to database.
 * @param session the open session to use
 * @param username the username to persist to database
 */
fun saveUser(session: Session, username: String) {
  val user =
      User(
          username,
      )
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
