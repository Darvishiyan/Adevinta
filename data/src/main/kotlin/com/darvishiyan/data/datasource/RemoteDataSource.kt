package com.darvishiyan.data.datasource

import com.darvishiyan.entity.remote.MotorImage


interface RemoteDataSource {
    suspend fun fetchImage(): Result<List<MotorImage>>
}
