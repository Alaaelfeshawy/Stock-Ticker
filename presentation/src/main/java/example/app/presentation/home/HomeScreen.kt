package example.app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import example.app.presentation.home.model.ChangeUi
import example.app.presentation.home.model.StockUiModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<HomeViewModel>()

    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getStocksList()
    }

    HomeScreenContent(modifier,state)
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: HomeUiState,
 ) {
    Scaffold {
        Column(
            modifier = modifier.padding(it),
        ){
            if (state.isLoading == true) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }

            state.stockList?.let {
                LazyColumn {
                    items(it){
                        StockItem(it)
                    }
                }
            }

        }
    }

}
@Composable
private fun StockItem(stock : StockUiModel){
   Column {
       Row(
           modifier = Modifier.fillMaxWidth()
               .padding(horizontal = 12.dp , vertical = 6.dp),
           horizontalArrangement = Arrangement.SpaceBetween
       ){
           Column {
               Text(stock.symbol , style = TextStyle(
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Bold
               ))
               Text(stock.name , style = TextStyle(
                   fontSize = 18.sp,
                   fontWeight = FontWeight.Medium,
                   color = Color.Gray
               ))
           }

           Column(
               horizontalAlignment = Alignment.End
           ){
               Text(stock.price.toString() ,style = TextStyle(
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Bold
               ))
               Box (
                   modifier = Modifier.width(75.dp)
                       .clip(RoundedCornerShape(6.dp))
                       .background(stock.change.backgroundColor)
               ){
                   Text(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(8.dp),
                       text = stock.change.change.toString(),
                       style = TextStyle(
                           color = Color.White,
                           fontWeight = FontWeight.Medium
                       ),
                       textAlign = TextAlign.End
                   )
               }
           }
       }

       HorizontalDivider( modifier = Modifier.padding(vertical = 2.dp , horizontal = 12.dp))
   }
}

@Preview
@Composable
fun PreviewHomeScreen(modifier: Modifier = Modifier) {

    HomeScreenContent(
        modifier = modifier,
        state = HomeUiState(
            stockList = listOf(
                StockUiModel("AAPL", "Apple Inc.", 190.12, ChangeUi( -1.45, -0.76 , Color.Red), "USD"),
                StockUiModel("GOOGL", "Alphabet Inc.", 2751.35, ChangeUi(15.62, 0.57,Color(0xFF4CAF50)),"USD"),
                StockUiModel("TSLA", "Tesla Inc.", 710.22, ChangeUi(5.18, 0.73, Color(0xFF4CAF50)),"USD"),
            )
        )
    )
}
