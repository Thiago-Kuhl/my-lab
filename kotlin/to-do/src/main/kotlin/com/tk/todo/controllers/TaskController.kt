package com.tk.todo.controllers

import com.tk.todo.models.Task
import com.tk.todo.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tasks")
class TaskController(private val service: TaskService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun retriveAllTasks(): Collection<Task> = service.retriveAllTask()

    @GetMapping("/{taskId}")
    fun retriveTaskById(@PathVariable taskId: Long): Task = service.getTaskById(taskId)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewTask(@RequestBody task: Task): Task = service.createNewTask(task)

    @PatchMapping
    fun updateTask(@RequestBody task: Task): String = service.updateTask(task)

    @DeleteMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTask(@PathVariable taskId: Long): String = service.deleteTask(taskId)
}