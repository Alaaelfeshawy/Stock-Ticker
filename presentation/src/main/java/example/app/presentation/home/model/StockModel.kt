package example.app.presentation.home.model

import androidx.compose.ui.graphics.Color
import example.app.domain.model.StockModel
import javax.annotation.concurrent.Immutable

@Immutable
data class StockUiModel(
    val symbol: String,
    val name: String,
    val price: Double,
    val change: ChangeUi,
    val currency: String
)

@Immutable
data class ChangeUi(
    val change: Double,
    val changePercent: Double,
    val backgroundColor : Color,
)

fun StockModel.mapToStockModel() : StockUiModel {
    return StockUiModel(
        symbol = this.symbol,
        name = this.name,
        price = this.price,
        change = ChangeUi(
            change = this.change,
            changePercent = this.changePercent,
            backgroundColor = if (change > 0.0) Color(0xFF4CAF50) else Color.Red
        ),
        currency = this.currency
    )
}