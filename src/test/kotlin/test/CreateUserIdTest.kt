package test

import data.insertUser
import kotlin.test.assertEquals
import org.junit.Before
import org.junit.Test

class CreateUserIdTest {

  @Before fun setup() {}

  @Test
  internal fun testUserId() {
    val user = insertUser("frank")
    assertEquals(0, user.id)
  }

  //  @Test
  //  fun givenPerson_whenSaved_thenFound() {
  //    doInHibernate(({ this.sessionFactory() }), { session ->
  //      val personToSave = Person(0, "John")
  //      session.persist(personToSave)
  //      val personFound = session.find(Person::class.java, personToSave.id)
  //      session.refresh(personFound)
  //      assertTrue(personToSave == personFound)
  //    })
  //  }
}
