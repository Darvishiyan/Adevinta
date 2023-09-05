package com.darvishiyan.repository

import com.darvishiyan.data.datasource.RemoteDataSource
import com.darvishiyan.data.di.IODispatcher
import com.darvishiyan.domain.repository.ImageRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher,
) : ImageRepository {
    override suspend fun fetchImages() = withContext(coroutineDispatcher) { remoteDataSource.fetchImage() }
}
