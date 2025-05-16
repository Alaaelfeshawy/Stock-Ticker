package example.app.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import example.app.data.Trading
import example.app.data.Yahoo
import example.app.data.home.adapter.TradingAdapter
import example.app.data.home.adapter.YahooAdapter
import example.app.data.home.datasource.IHomeDataSource
import example.app.data.home.datasource.TradingDataSource
import example.app.data.home.datasource.YahooDataSource
import example.app.data.home.repository.HomeRepositoryImpl
import example.app.domain.StockPort
import example.app.domain.repository.IHomeRepository

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    @ViewModelScoped
    fun provideHomeRepository(sources: @JvmSuppressWildcards Set<StockPort>): IHomeRepository {
        return HomeRepositoryImpl(sources.toList())
    }

    @Provides
    @ViewModelScoped
    fun provideYahooAdapter(@Yahoo dataSource: IHomeDataSource): StockPort {
        return YahooAdapter(dataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideTradingSourceAdapter(@Trading dataSource: IHomeDataSource): StockPort {
        return TradingAdapter(dataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideSources(
        yahooAdapter: YahooAdapter,
        tradingAdapter: TradingAdapter
    ): Set<StockPort> = setOf(yahooAdapter, tradingAdapter)

    @Provides
    @ViewModelScoped
    @Yahoo
    fun provideYahooDataSource(): IHomeDataSource {
        return YahooDataSource()
    }

    @Provides
    @ViewModelScoped
    @Trading
    fun provideTradingDataSource(): IHomeDataSource {
        return TradingDataSource()
    }
}