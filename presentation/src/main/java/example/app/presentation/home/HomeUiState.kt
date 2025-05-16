package example.app.presentation.home

import example.app.presentation.home.model.StockUiModel

data class HomeUiState(
    val isLoading : Boolean?=null,
    val stockList : List<StockUiModel>?=null
)
