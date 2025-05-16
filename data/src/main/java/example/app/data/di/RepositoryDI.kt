package example.app.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import example.app.data.home.datasource.HomeDataSourceImpl
import example.app.data.home.datasource.IHomeDataSource
import example.app.data.home.repository.HomeRepositoryImpl
import example.app.domain.repository.IHomeRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): IHomeRepository

    @Binds
    @ViewModelScoped
    abstract fun bindsHomeDataSource(homeDataSourceImpl: HomeDataSourceImpl): IHomeDataSource

}