package com.tk.todo.models

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Task(
    @JsonProperty("task_id")
    val taskId: Long,

    @JsonProperty("task_name")
    val taskName: String,

    @JsonProperty("description")
    val description: String,

    @JsonProperty("priority")
    val priority: Int,

    @JsonProperty("start_date")
    val startDate: Date,

    @JsonProperty("end_date")
    val endDate: Date? = null
)
