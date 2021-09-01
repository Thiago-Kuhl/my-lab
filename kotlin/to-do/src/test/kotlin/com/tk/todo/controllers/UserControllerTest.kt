package com.tk.todo.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class UserControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {

    val baseUrl = "/api/v1/users"

    @Nested
    @DisplayName("GET /api/v1/users")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class getUsers {
        @Test
        fun `should return OK when give all users succesfully`() {

            //when/then
            mockMvc.get(baseUrl)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                }
        }
    }

    @Nested
    @DisplayName("GET /api/v1/users/{user_id}")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class getUserByUserId {
        @Test
        fun `should return 200 when given user id exists`() {
            //given
            val validUserId = UUID.fromString("2308ce07-6084-40e8-9c33-f126eae5ee8f")

            //when
            mockMvc.get("$baseUrl/$validUserId")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                    }
                    jsonPath("$.id") { value(validUserId.toString()) }

                }
            //then
        }
    }
}