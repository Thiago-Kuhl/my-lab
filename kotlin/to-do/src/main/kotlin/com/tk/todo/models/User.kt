package com.tk.todo.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.util.*

data class User(
    @JsonProperty("id")
    val id: UUID? = UUID.randomUUID(),

    @JsonProperty("name")
    val name: String? = null,

    @JsonProperty("last_name")
    val lastName: String? = null,

    @JsonProperty("username")
    val username: String,

    @JsonProperty("created_at")
    val createdAt: Date = Date.from(Instant.now()),

    @JsonProperty("updated_at")
    val updatedAt: Date? = null
)
