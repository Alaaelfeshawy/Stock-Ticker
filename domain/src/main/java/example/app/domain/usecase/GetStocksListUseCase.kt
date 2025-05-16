package example.app.domain.usecase

import example.app.domain.model.StockModel
import example.app.domain.repository.IHomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetStocksListUseCase @Inject constructor(
   private val iHomeRepository : IHomeRepository
) {

    operator fun invoke(): Flow<List<StockModel>> {
        return flow {
            emit(iHomeRepository.getStocks())
        }
    }

}