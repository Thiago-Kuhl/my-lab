package com.currency.quote

import com.currency.quote.configuration.CurrencyQuoteClientConfig
import com.currency.quote.configuration.TelegramClientConfig
import com.currency.quote.gateway.CurrencyQuoteClient
import com.currency.quote.gateway.TelegramClient

fun main() {
    val botToken = System.getenv("BOT_TOKEN")
    val chatId = System.getenv("CHAT_ID")

    val currencyQuoteClient: CurrencyQuoteClient = CurrencyQuoteClientConfig().builder()
    val telegramClient: TelegramClient = TelegramClientConfig().builder()

    val dolarRate = currencyQuoteClient.getDolarRate().dolar.currency
    val euroRate = currencyQuoteClient.getEuroRate().euro.currency

    val message = buildTelegramMessage(dolarRate, euroRate)
    telegramClient.sendMessage(botToken, chatId, message)

}

fun buildTelegramMessage(dolarRate: String, euroRate: String): String {
    val currencyFormater = "%.2f"

    return """
    A cotação atual do dólar é: R$${currencyFormater.format(dolarRate.toFloat())}
    A cotação atual do euro é: R$${currencyFormater.format(euroRate.toFloat())}
""".trimIndent()
}