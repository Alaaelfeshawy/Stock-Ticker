package example.app.data.home.datasource

import example.app.data.home.model.StockDataModel

class TradingDataSource : IHomeDataSource {
    override suspend fun getStocks(): List<StockDataModel> {
        return listOf(
            StockDataModel("BRK.A", "Berkshire Hathaway Inc.", 631525.00, -1025.50, -0.16, "USD"),
            StockDataModel("JNJ", "Johnson & Johnson", 161.44, 0.78, 0.49, "USD"),
            StockDataModel("PFE", "Pfizer Inc.", 33.55, -0.21, -0.62, "USD"),
            StockDataModel("KO", "Coca-Cola Co.", 62.81, 0.35, 0.56, "USD"),
            StockDataModel("PEP", "PepsiCo Inc.", 179.32, -0.64, -0.36, "USD"),
            StockDataModel("WMT", "Walmart Inc.", 158.90, 1.24, 0.79, "USD"),
            StockDataModel("COST", "Costco Wholesale Corp.", 752.55, 5.67, 0.76, "USD"),
            StockDataModel("MCD", "McDonald's Corp.", 284.23, -2.18, -0.76, "USD"),
            StockDataModel("NKE", "Nike Inc.", 104.15, 0.92, 0.89, "USD"),
            StockDataModel("SBUX", "Starbucks Corp.", 92.61, -1.45, -1.54, "USD"),
            StockDataModel("T", "AT&T Inc.", 17.11, 0.12, 0.71, "USD"),
            StockDataModel("VZ", "Verizon Communications", 39.22, 0.44, 1.14, "USD"),
            StockDataModel("CVX", "Chevron Corp.", 161.32, -2.55, -1.56, "USD"),
            StockDataModel("XOM", "Exxon Mobil Corp.", 113.45, 0.65, 0.58, "USD"),
            StockDataModel("BP", "BP PLC", 36.81, -0.28, -0.76, "USD"),
            StockDataModel("RIVN", "Rivian Automotive Inc.", 12.45, 0.39, 3.23, "USD"),
            StockDataModel("PLTR", "Palantir Technologies", 22.74, -0.16, -0.70, "USD"),
            StockDataModel("SNOW", "Snowflake Inc.", 161.18, 1.32, 0.83, "USD"),
            StockDataModel("UBS", "UBS Group AG", 28.75, -0.11, -0.38, "USD"),
            StockDataModel("HSBC", "HSBC Holdings", 41.21, 0.19, 0.46, "USD")
        )
    }
}