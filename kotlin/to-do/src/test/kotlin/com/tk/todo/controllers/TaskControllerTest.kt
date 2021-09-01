package com.tk.todo.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.tk.todo.models.Task
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*
import java.time.Instant
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class TaskControllerTest @Autowired constructor(
    private
    val mockMvc: MockMvc,
    private
    val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/v1/tasks"
    val invalidTaskId = "1234567890"

    @Nested
    @DisplayName("GET /api/v1/tasks")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class getAllTasks {
        @Test
        fun `should retrieve all tasks `() {
            //when/then
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].task_id") { value(1) }
                }
        }
    }

    @Nested
    @DisplayName("GET /api/v1/tasks/{task_id}")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class getTasksByTaskId {

        @Test
        fun `should return OK when find a given task id`() {
            //given
            val taskId = 1

            //when/then
            mockMvc.get("$baseUrl/$taskId")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }
        }

        @Test
        fun `should return NOT FOUND when does not find task`() {
            //when/then
            mockMvc.get("$baseUrl/$invalidTaskId")
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                    content {
                        contentType("${MediaType.TEXT_PLAIN};charset='UTF-8'")
                    }
                }
        }
    }

    @Nested
    @DisplayName("POST /api/v1/tasks")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class createNewTasks {

        @Test
        fun `should return CREATED when succesfully create a new task`() {
            //given
            val newTask = Task(
                4,
                "Integrate the app with backend",
                "Create a complete integration with app To-Do and To-Do bankend application.",
                1,
                Date.from(Instant.now()),
                Date.from(Instant.now().plusSeconds(3600 * 60))
            )
            //when
            mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newTask)
            }
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }
            //then
            mockMvc.get("$baseUrl/${newTask.taskId}")
                .andExpect { status { isOk() } }
        }

        @Test
        fun `should should return BAD REQUEST when a given repeted task id`() {
            //given
            val newInvalidTask = Task(
                1,
                "Integrate the app with backend",
                "Create a complete integration with app To-Do and To-Do bankend application.",
                1,
                Date.from(Instant.now()),
                Date.from(Instant.now().plusSeconds(3600 * 60))
            )
            //when/then
            mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newInvalidTask)
            }
                .andDo { print() }
                .andExpect { status { isBadRequest() } }
        }

        @Test
        fun `should return BAD REQUEST when some required field is invalid`() {
            //given
            val newInvalidTask = Task(
                5,
                "Integrate To-Do App with To-Do backend application",
                "Full integration to be a functional app.",
                0,
                Date.from(Instant.now()),
                Date.from(Instant.now().plusSeconds(3600 * 60))
            )
            //when/then
            mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newInvalidTask)
            }
                .andDo { print() }
                .andExpect { status { isBadRequest() } }

        }
    }

    @Nested
    @DisplayName("PATCH /api/v1/tasks")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class updateTasks {

        @Test
        fun `should return OK when succesfully update an task `() {
            //given
            val taskChanges = Task(
                1,
                "Integrate the app with backend updated",
                "",
                1,
                Date.from(Instant.now()),
                Date.from(Instant.now().plusSeconds(3600 * 60))
            )

            //when
            val updateTask = mockMvc.patch(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(taskChanges)
            }

            //then
            updateTask
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType("${MediaType.TEXT_PLAIN};charset=UTF-8") }
                }

            mockMvc.get("$baseUrl/${taskChanges.taskId}")
                .andExpect { content { json(objectMapper.writeValueAsString(taskChanges)) } }
        }

        @Test
        fun `should should return NOT FOUND when given an invalid task id`() {
            //given
            val InvalidTaskUpdate = Task(
                55,
                "Integrate To-Do App with To-Do backend application",
                "Full integration to be a functional app.",
                1,
                Date.from(Instant.now()),
                Date.from(Instant.now().plusSeconds(3600 * 60))
            )
            //when
            val updateTask = mockMvc.patch(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(InvalidTaskUpdate)
            }

            //then
            updateTask
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                    content { contentType("${MediaType.TEXT_PLAIN};charset=UTF-8") }
                }
        }
    }

    @Nested
    @DisplayName("DELETE /api/v1/tasks/{task_id}")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class deleteTasks {

        @Test
        fun `should return NO CONTENT when succesfully delete an task`() {
            //given
            val taskId = 1
            //when
            mockMvc.delete("$baseUrl/$taskId")
                .andDo { print() }
                .andExpect { status { isNoContent() } }

            //then
            mockMvc.get("$baseUrl/$taskId")
                .andExpect {
                    status { isNotFound() }
                }
        }

        @Test
        fun `should return NOT FOUND when an given task id does not exists`() {
            //given
            val invalidTaskId = 1234567890
            //when
            mockMvc.delete("$baseUrl/$invalidTaskId")
                .andDo { print() }
                .andExpect { status { isNotFound() } }
            //then
        }
    }

}