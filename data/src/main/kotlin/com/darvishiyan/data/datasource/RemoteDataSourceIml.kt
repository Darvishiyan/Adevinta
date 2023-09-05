package com.darvishiyan.data.datasource

import com.darvishiyan.data.remote.ApiService
import com.darvishiyan.entity.remote.MotorImage
import javax.inject.Inject

class RemoteDataSourceIml @Inject constructor(private val api: ApiService) : RemoteDataSource {
    override suspend fun fetchImage(): Result<List<MotorImage>> {
        return try {
            Result.success(api.fetchImage().images)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
