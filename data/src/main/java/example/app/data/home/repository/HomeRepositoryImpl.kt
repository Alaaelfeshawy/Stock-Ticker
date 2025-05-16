package example.app.data.home.repository

import example.app.data.home.datasource.IHomeDataSource
import example.app.data.home.model.mapTpStockModel
import example.app.domain.model.StockModel
import example.app.domain.repository.IHomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val iHomeDataSource: IHomeDataSource
) : IHomeRepository{
    override suspend fun getStocks(): List<StockModel> {
        return iHomeDataSource.getStocks().map {
            it.mapTpStockModel()
        }
    }
}