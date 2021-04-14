package test

import data.User
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test

class CreateUserIdTest {

  @Before fun setup() {}

  @Test
  internal fun testUserId() {
    val user = User(0, "frank")
    assertEquals(0, user.id)
  }

  //  @Test
  //  fun givenPerson_whenSaved_thenFound() {
  //    doInHibernate(
  //        ({ sessionFactory }),
  //        { session ->
  //          val userToSave = User(0, "frank")
  //          session.persist(userToSave)
  //          val userFound = session.find(User::class.java, userToSave.id)
  //          session.refresh(userFound)
  //          assertTrue(userToSave.name == userFound.name)
  //        })
  //  }
}
