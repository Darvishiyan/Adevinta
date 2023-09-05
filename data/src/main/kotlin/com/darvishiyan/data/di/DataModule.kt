package com.darvishiyan.data.di

import com.darvishiyan.data.datasource.RemoteDataSource
import com.darvishiyan.data.datasource.RemoteDataSourceIml
import com.darvishiyan.domain.repository.ImageRepository
import com.darvishiyan.repository.ImageRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindDataSource(dataSource: RemoteDataSourceIml): RemoteDataSource

    @Binds
    abstract fun bindImageRepository(repo: ImageRepositoryImpl): ImageRepository

}
