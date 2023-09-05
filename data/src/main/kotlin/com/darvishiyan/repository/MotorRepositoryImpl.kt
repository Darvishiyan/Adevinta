package com.darvishiyan.repository

import com.darvishiyan.data.datasource.RemoteDataSource
import com.darvishiyan.data.di.IODispatcher
import com.darvishiyan.domain.repository.MotorRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MotorRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IODispatcher private val coroutineDispatcher: CoroutineDispatcher,
) : MotorRepository {
    override suspend fun fetchMotor() =
        withContext(coroutineDispatcher) { remoteDataSource.fetchImage() }
}
