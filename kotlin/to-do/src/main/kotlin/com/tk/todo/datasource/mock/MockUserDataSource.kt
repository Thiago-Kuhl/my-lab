package com.tk.todo.datasource.mock

import com.tk.todo.datasource.repository.UserDataRepository
import com.tk.todo.models.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MockUserDataSource : UserDataRepository {

    val users = mutableListOf(
        User(UUID.fromString("648e975d-1ffc-448f-9426-e32a0f4869a6"), "Thiago", "Kühl", "tkuhl"),
        User(UUID.fromString("5068656d-4c9e-4d84-8dd7-ffc4389aa6ca"), "Letícia", "Móri", "lmori"),
        User(UUID.fromString("2308ce07-6084-40e8-9c33-f126eae5ee8f"), null, null, "tk-lm"),
    )

    override fun getAllUsers(): Collection<User> {
        return users
    }

    override fun getUserById(userId: String): User {
        val currentUser = users.firstOrNull() { it.id == UUID.fromString(userId) }
            ?: throw NoSuchElementException("User with id '$userId' not found!")

        return currentUser
    }
}