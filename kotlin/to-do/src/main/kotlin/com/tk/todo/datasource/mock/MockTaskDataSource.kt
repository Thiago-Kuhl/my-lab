package com.tk.todo.datasource.mock

import com.tk.todo.datasource.TaskDataRepository
import com.tk.todo.models.Task
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
class MockTaskDataSource : TaskDataRepository {
    val tasks =
        mutableListOf(
            Task(
                1,
                "Create a TO-DO Backend",
                "Create a complete backend service for a To-Do app.",
                1,
                Date.from(Instant.now())
            ),
            Task(
                2,
                "Create a backend",
                "Create a complete backend service for an app.",
                2,
                Date.from(Instant.now().minusSeconds(3600 * 2))
            ),
            Task(
                3,
                "Create a app",
                "Create a complete app for to-do backend.",
                3,
                Date.from(Instant.now().minusSeconds(3600 * 3))
            )
        )

    override fun retrieveAllTasks(): Collection<Task> {
        return tasks
    }

    override fun getTaskById(taskId: Long): Task {
        val currentTask = tasks.firstOrNull() { it.taskId == taskId }
            ?: throw NoSuchElementException("Could not find any task with task id: $taskId")

        return currentTask
    }

    override fun createNewTask(task: Task): Task {
        when {
            tasks.any { it.taskId == task.taskId } -> {
                throw IllegalArgumentException("Task with task id ${task.taskId} already exists.")
            }
            task.taskId.toString().isEmpty() || task.taskId < 1 -> {
                throw IllegalArgumentException("Field 'task_id' is required!")
            }
            task.taskName.isEmpty() -> {
                throw IllegalArgumentException("Field 'task_name' is required!")
            }
            task.description.isEmpty() -> {
                throw IllegalArgumentException("Field 'description' is required!")
            }
            task.priority.toString().isEmpty() -> {
                throw IllegalArgumentException("Field 'priority' is required!")
            }
            task.priority < 1 || task.priority > 5 -> {
                throw IllegalArgumentException("Field 'priority' value must be between 1 and 5!")
            }
            task.startDate.toString().isEmpty() -> {
                throw IllegalArgumentException("Field 'start_date' is required!")
            }
            else -> {
                tasks.add(task)
            }
        }

        return task
    }

    override fun updateTask(task: Task): String {
        val currentTask = tasks.firstOrNull() { it.taskId == task.taskId }
            ?: throw NoSuchElementException("Could not find any task with task id: ${task.taskId}.")

        if (task.taskId.toString().isEmpty()) {
            throw IllegalArgumentException("Field 'task_id' is required!")
        } else {
            tasks.remove(currentTask)

            tasks.add(task)
        }

        return "Task with task id ${task.taskId} was succesfully updated!"
    }

    override fun deleteTask(taskId: Long): String {
        val currentTask = tasks.firstOrNull() { it.taskId == taskId }
            ?: throw NoSuchElementException("Could not find any task with task id: ${taskId}.")

        tasks.remove(currentTask)

        return "Task with task id '$taskId' was succesfully deleted!"
    }


}