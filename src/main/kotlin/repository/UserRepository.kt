package repository

import data.User

class UserRepository(private val user: User) : DBRepository {
    override fun addUser(user: User): Int {
        TODO("Not yet implemented")
    }
}
