package com.darvishiyan.domain.repository

import com.darvishiyan.entity.remote.MotorImage


interface ImageRepository {
    suspend fun fetchImages(): Result<List<MotorImage>>
}
