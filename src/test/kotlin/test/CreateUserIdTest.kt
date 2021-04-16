package test

import data.User
import data.addUser
import data.getSessionFactoryFromConfig
import data.getUsers
import kotlin.test.Test
import kotlin.test.assertEquals
import org.hibernate.testing.transaction.TransactionUtil.doInHibernate
import org.junit.jupiter.api.assertThrows

class CreateUserIdTest {

  companion object {
    const val BAD_NAME = "EVIL"
    const val GOOD_NAME = "good"
  }

  @Test
  fun isInvalidName() {
    assertThrows<IllegalArgumentException> { User(BAD_NAME) }
  }

  @Test
  fun addUser_thenFound() {
    val users: List<User> = addUser(GOOD_NAME)
    assertEquals(1, users.size)
    val (name, id) = users[0]
    assertEquals(1, id)
    assertEquals(GOOD_NAME, name)
  }

  @Test
  fun saveUser_thenFound() {
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
  fun empty_list() {
    val sessionFactory = getSessionFactoryFromConfig()
    doInHibernate(({ sessionFactory })) { session ->
      val users = getUsers(session)
      assertEquals(0, users.size)
    }
    sessionFactory.close()
  }
}
