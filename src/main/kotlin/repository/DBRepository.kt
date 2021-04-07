package repository

import data.User

interface DBRepository {
  fun addUser(user: User): Int
}
