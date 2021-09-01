package com.tk.todo.service

import com.tk.todo.datasource.repository.UserDataRepository
import com.tk.todo.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private val datasource: UserDataRepository) {
    fun getAllUsers(): Collection<User> = datasource.getAllUsers()
    fun getUserById(userId: String): User = datasource.getUserById(userId)
}