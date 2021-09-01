package com.tk.todo.service

import com.tk.todo.datasource.repository.TaskDataRepository
import com.tk.todo.models.Task
import org.springframework.stereotype.Service

@Service
class TaskService(private val dataSource: TaskDataRepository) {
    fun retriveAllTask(): Collection<Task> = dataSource.retrieveAllTasks()
    fun getTaskById(taskId: Long): Task = dataSource.getTaskById(taskId)
    fun createNewTask(task: Task): Task = dataSource.createNewTask(task)
    fun updateTask(task: Task): String = dataSource.updateTask(task)
    fun deleteTask(taskId: Long): String = dataSource.deleteTask(taskId)

}