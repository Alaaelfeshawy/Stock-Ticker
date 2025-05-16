package example.app.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class StockModel(
    val symbol: String,
    val name: String,
    val price: Double,
    val change: Double,
    val changePercent: Double,
    val currency: String
)
