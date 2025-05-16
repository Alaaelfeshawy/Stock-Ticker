package example.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import example.app.domain.usecase.GetStocksListUseCase
import example.app.presentation.home.model.mapToStockModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getStocksListUseCase: GetStocksListUseCase,
) : ViewModel() {

    private var _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    fun getStocksList(){
        getStocksListUseCase()
            .onStart {
                _state.value = _state.value.copy(
                    isLoading = true
                )
            }.onEach { stocks ->
                _state.value = _state.value.copy(
                    stockList = stocks.map {
                        it.mapToStockModel()
                    }
                )
            }.onCompletion {
                _state.value = _state.value.copy(
                    isLoading = false
                )
            }.launchIn(viewModelScope)
    }

}