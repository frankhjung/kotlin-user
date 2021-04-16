package data

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * A simple User data structure. Contains two fields:
 * @param name the username to persist
 * @property id the auto-generated user identifier
 */
@Entity(name = "user")
@Table(name = "user")
data class User(
    @Column(name = "name", nullable = false, unique = true) val name: String,
) {

  /** Auto-generated user identifier. */
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") var id: Int = 0

  /** Check name is lowercase alphabetic. */
  init {
    require(isValidName(name)) { "Only lowercase alphabetic characters allowed" }
  }

  /** Define id as the second component. */
  operator fun component2() = this.id

  /**
   * Name validation.
   * @param name the user name to check
   * @return Boolean True if user name is valid, False otherwise.
   */
  private fun isValidName(name: String): Boolean = name.matches("[a-z]+".toRegex())
}
