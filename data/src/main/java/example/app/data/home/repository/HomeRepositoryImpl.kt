package example.app.data.home.repository

import example.app.domain.StockPort
import example.app.domain.model.StockModel
import example.app.domain.repository.IHomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val sources: List<StockPort>
) : IHomeRepository{
    override suspend fun getStocks(): List<StockModel> {
        return sources.flatMap { source ->
            runCatching { source.fetchStocks() }
                .getOrElse { emptyList() }
        }
    }
}