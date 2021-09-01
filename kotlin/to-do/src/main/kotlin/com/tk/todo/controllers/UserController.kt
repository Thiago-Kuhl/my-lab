package com.tk.todo.controllers

import com.tk.todo.models.User
import com.tk.todo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun getAllUsers(): Collection<User> = service.getAllUsers()

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String): User = service.getUserById(userId)
}