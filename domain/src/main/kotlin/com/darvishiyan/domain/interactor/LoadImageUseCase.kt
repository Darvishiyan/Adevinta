package com.darvishiyan.domain.interactor

import com.darvishiyan.domain.repository.MotorRepository
import com.darvishiyan.entity.remote.MotorImage
import javax.inject.Inject

interface LoadImageUseCase {
    suspend operator fun invoke(): Result<List<MotorImage>>
}

class LoadImageUseCaseImpl @Inject constructor(private val repository: MotorRepository) : LoadImageUseCase {
    override suspend fun invoke() = repository.fetchMotor()
}
