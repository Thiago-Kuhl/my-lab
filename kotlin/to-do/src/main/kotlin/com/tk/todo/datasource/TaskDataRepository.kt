package com.tk.todo.datasource

import com.tk.todo.models.Task

interface TaskDataRepository {
    fun retrieveAllTasks(): Collection<Task>
    fun getTaskById(taskId: Long): Task
    fun createNewTask(task: Task): Task
    fun updateTask(task: Task): String
    fun deleteTask(taskId: Long): String
}