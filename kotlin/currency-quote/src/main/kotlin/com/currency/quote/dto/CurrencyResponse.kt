package com.currency.quote

import com.fasterxml.jackson.annotation.JsonProperty

data class DolarCurrencyResponse(
    @JsonProperty("USDBRL")
    val dolar: Currency
)

data class Currency(
    @JsonProperty("bid")
    val currency: String
)

data class EuroCurrencyResponse(
    @JsonProperty("EURBRL")
    val euro: Currency

)