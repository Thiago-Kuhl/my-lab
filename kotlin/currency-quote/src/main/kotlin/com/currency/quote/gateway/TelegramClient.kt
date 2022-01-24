package com.currency.quote.gateway

import feign.Param
import feign.RequestLine

interface TelegramClient {
    @RequestLine("POST /{botToken}/sendMessage?chat_id={chatId}&text={message}")
    fun sendMessage(
        @Param("botToken") botToken: String,
        @Param("chatId") chatId: String,
        @Param("message") message: String,
    )
}