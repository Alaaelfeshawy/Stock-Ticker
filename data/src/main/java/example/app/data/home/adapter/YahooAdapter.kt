package example.app.data.home.adapter

import example.app.data.Yahoo
import example.app.data.home.datasource.IHomeDataSource
import example.app.data.home.model.mapToStockModel
import example.app.domain.StockPort
import example.app.domain.model.StockModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class YahooAdapter @Inject constructor(
 @Yahoo private val iHomeDataSource : IHomeDataSource
): StockPort {

    override suspend fun fetchStocks(): List<StockModel> {
        delay(800)
        return iHomeDataSource.getStocks().map { it.mapToStockModel() }
    }

}

