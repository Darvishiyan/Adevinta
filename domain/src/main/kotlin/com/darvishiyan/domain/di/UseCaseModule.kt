package com.darvishiyan.domain.di

import com.darvishiyan.domain.interactor.LoadImageUseCase
import com.darvishiyan.domain.interactor.LoadImageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindLoadMotorImage(useCase: LoadImageUseCaseImpl): LoadImageUseCase

}
