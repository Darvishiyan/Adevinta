package com.darvishiyan.domain.interactor

import com.darvishiyan.domain.repository.ImageRepository
import com.darvishiyan.entity.remote.MotorImage
import javax.inject.Inject

interface LoadImageUseCase {
    suspend operator fun invoke(): Result<List<MotorImage>>
}

class LoadImageUseCaseImpl @Inject constructor(private val repository: ImageRepository) : LoadImageUseCase {
    override suspend fun invoke() = repository.fetchImages()
}
