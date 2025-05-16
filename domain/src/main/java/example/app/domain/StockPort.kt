package example.app.domain

import example.app.domain.model.StockModel

interface StockPort {
    suspend fun fetchStocks(): List<StockModel>
}