package com.darvishiyan.domain.repository

import com.darvishiyan.entity.remote.MotorImage


interface MotorRepository {
    suspend fun fetchMotor(): Result<List<MotorImage>>
}
