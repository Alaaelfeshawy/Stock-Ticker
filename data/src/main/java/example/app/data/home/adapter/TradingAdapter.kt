package example.app.data.home.adapter

import example.app.data.Trading
import example.app.data.home.datasource.IHomeDataSource
import example.app.data.home.model.mapToStockModel
import example.app.domain.StockPort
import example.app.domain.model.StockModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class TradingAdapter @Inject constructor(
   @Trading private val iHomeDataSource : IHomeDataSource
): StockPort {

    override suspend fun fetchStocks(): List<StockModel> {
        delay(900)
        return iHomeDataSource.getStocks().map { it.mapToStockModel() }
    }
}

