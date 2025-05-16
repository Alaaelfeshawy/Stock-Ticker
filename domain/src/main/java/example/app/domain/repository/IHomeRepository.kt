package example.app.domain.repository

import example.app.domain.model.StockModel

interface IHomeRepository {

    suspend fun getStocks(): List<StockModel>
}