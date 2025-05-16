package example.app.data.home.model

import example.app.domain.model.StockModel
import javax.annotation.concurrent.Immutable

@Immutable
data class StockDataModel(
    val symbol: String,
    val name: String,
    val price: Double,
    val change: Double,
    val changePercent: Double,
    val currency: String
)

fun StockDataModel.mapTpStockModel() : StockModel{
    return StockModel(
        symbol = this.symbol,
        name = this.name,
        price = this.price,
        change = this.change,
        changePercent = this.changePercent,
        currency = this.currency
    )
}