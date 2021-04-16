package test

import data.User
import data.addUsers
import data.getSessionFactoryFromConfig
import data.getUsers
import kotlin.test.Test
import kotlin.test.assertEquals
import mu.KotlinLogging
import org.hibernate.testing.transaction.TransactionUtil.doInHibernate
import org.junit.jupiter.api.assertThrows

private val logger = KotlinLogging.logger {}

class CreateUserIdTest {

  companion object {
    const val BAD_NAME = "BaD_nAmE"
    const val GOOD_NAME = "goodname"
  }

  @Test
  fun isInvalidName() {
    logger.debug("check $BAD_NAME is invalid")
    assertThrows<IllegalArgumentException> { User(BAD_NAME) }
  }

  @Test
  fun addSingleUserThenFound() {
    logger.debug("add single user ${GOOD_NAME}NAME")
    val users: List<User> = addUsers(listOf(GOOD_NAME))
    assertEquals(1, users.size)
    val (name, id) = users[0]
    assertEquals(1, id)
    assertEquals(GOOD_NAME, name)
  }

  @Test
  fun addEmptyListOfUsers() {
    logger.debug("no failure when given an empty list")
    val users: List<User> = addUsers(emptyList())
    assertEquals(0, users.size)
  }

  @Test
  fun saveUserThenFound() {
    logger.debug("save user and then retrieve")
    val sessionFactory = getSessionFactoryFromConfig()
    doInHibernate(({ sessionFactory })) { session ->
      val userToSave = User(GOOD_NAME)
      session.persist(userToSave)
      val userFound = session.find(User::class.java, userToSave.id)
      session.refresh(userFound)
      assertEquals(userToSave, userFound)
    }
    sessionFactory.close()
  }

  @Test
  fun getWhenEmptyDatabase() {
    logger.debug("no failure when database is empty")
    val sessionFactory = getSessionFactoryFromConfig()
    doInHibernate(({ sessionFactory })) { session ->
      val users = getUsers(session)
      assertEquals(0, users.size)
    }
    sessionFactory.close()
  }
}
