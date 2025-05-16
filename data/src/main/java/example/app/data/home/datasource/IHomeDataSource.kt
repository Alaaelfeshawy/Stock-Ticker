package example.app.data.home.datasource

import example.app.data.home.model.StockDataModel

interface IHomeDataSource {

    suspend fun getStocks() : List<StockDataModel>
}