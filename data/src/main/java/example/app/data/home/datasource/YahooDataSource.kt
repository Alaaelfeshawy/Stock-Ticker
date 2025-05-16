package example.app.data.home.datasource

import example.app.data.home.model.StockDataModel

class YahooDataSource : IHomeDataSource {
    override suspend fun getStocks(): List<StockDataModel> {
        return  listOf(
            StockDataModel("AAPL", "Apple Inc.", 190.12, -1.45, -0.76, "USD"),
            StockDataModel("GOOGL", "Alphabet Inc.", 2751.35, 15.62, 0.57, "USD"),
            StockDataModel("TSLA", "Tesla Inc.", 710.22, 5.18, 0.73, "USD"),
            StockDataModel("AMZN", "Amazon.com Inc.", 3445.15, -23.67, -0.68, "USD"),
            StockDataModel("MSFT", "Microsoft Corp.", 310.65, 2.89, 0.94, "USD"),
            StockDataModel("NFLX", "Netflix Inc.", 487.34, -4.23, -0.86, "USD"),
            StockDataModel("META", "Meta Platforms Inc.", 358.17, 3.76, 1.06, "USD"),
            StockDataModel("NVDA", "NVIDIA Corp.", 720.10, 12.34, 1.74, "USD"),
            StockDataModel("INTC", "Intel Corp.", 45.67, -0.34, -0.74, "USD"),
            StockDataModel("AMD", "Advanced Micro Devices", 112.30, 1.45, 1.31, "USD"),
            StockDataModel("BABA", "Alibaba Group", 87.65, -1.10, -1.24, "USD"),
            StockDataModel("DIS", "Walt Disney Co.", 103.75, 0.89, 0.86, "USD"),
            StockDataModel("BA", "Boeing Co.", 228.65, -3.20, -1.38, "USD"),
            StockDataModel("PYPL", "PayPal Holdings", 72.12, 0.42, 0.58, "USD"),
            StockDataModel("UBER", "Uber Technologies", 59.80, 1.12, 1.91, "USD"),
            StockDataModel("LYFT", "Lyft Inc.", 15.21, -0.28, -1.81, "USD"),
            StockDataModel("ORCL", "Oracle Corp.", 125.33, 0.76, 0.61, "USD"),
            StockDataModel("CRM", "Salesforce Inc.", 256.55, 2.50, 0.98, "USD"),
            StockDataModel("SHOP", "Shopify Inc.", 79.33, -0.67, -0.84, "USD"),
            StockDataModel("SQ", "Block Inc.", 69.12, -1.23, -1.75, "USD")
        )
    }
}