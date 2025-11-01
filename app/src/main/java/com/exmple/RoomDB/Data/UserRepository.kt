package com.exmple.RoomDB.Data

class UserRepository(private val dao: UserDao) {
    val users = dao.getAllUsers()

    suspend fun insert(user: User) = dao.insert(user)
    suspend fun deleteAll() = dao.deleteAll()
}