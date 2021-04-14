package test

import data.User
import data.addUser
import data.getSessionFactoryFromConfig
import data.getUsers
import data.isValidUsername
import org.hibernate.testing.transaction.TransactionUtil.doInHibernate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CreateUserIdTest {

  @Test
  internal fun givenValidUser_haveTrue() {
    assertTrue(isValidUsername("frank"))
  }

  @Test
  internal fun givenInValidUser_haveFalse() {
    assertFalse(isValidUsername("FRANK"))
  }

  @Test
  internal fun givenUser_haveId() {
    val user = User(0, "frank")
    assertEquals(0, user.id)
  }

  @Test
  internal fun addUser_thenFound() {
    val users = addUser("frank")
    assertEquals(1, users.size)
    assertEquals("frank", users[0].name)
  }

  @Test
  internal fun saveUser_thenFound() {
    val sessionFactory = getSessionFactoryFromConfig()
    doInHibernate(({ sessionFactory })) { session ->
      val userToSave = User(0, "frank")
      session.persist(userToSave)
      val userFound = session.find(User::class.java, userToSave.id)
      session.refresh(userFound)
      assertEquals(userToSave, userFound)
    }
    sessionFactory.close()
  }

  @Test
  internal fun empty_list() {
    val sessionFactory = getSessionFactoryFromConfig()
    doInHibernate(({ sessionFactory })) { session ->
      val users = getUsers(session)
      assertEquals(0, users.size)
    }
    sessionFactory.close()
  }
}