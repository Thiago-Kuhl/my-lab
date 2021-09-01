package com.tk.todo.datasource.repository

import com.tk.todo.models.User

interface UserDataRepository {
    fun getAllUsers(): Collection<User>
    fun getUserById(userId: String): User
}