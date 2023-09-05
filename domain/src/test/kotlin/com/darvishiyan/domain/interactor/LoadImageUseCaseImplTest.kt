package com.darvishiyan.domain.interactor

import com.darvishiyan.domain.repository.ImageRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoadImageUseCaseImplTest {

    @MockK
    lateinit var imageRepository: ImageRepository

    @InjectMockKs
    lateinit var loadImageUseCase: LoadImageUseCaseImpl


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `load image use case test`() = runTest {
        coEvery { imageRepository.fetchImages() } returns mockk()

        loadImageUseCase()

        coVerify { imageRepository.fetchImages() }
    }

    @Test
    fun `load image use case success test`() = runTest {
        coEvery { imageRepository.fetchImages() } returns Result.success(listOf())

        val result = loadImageUseCase()

        coVerify { imageRepository.fetchImages() }

        assertTrue(result.isSuccess)
        assertNotNull(result.getOrNull())
    }

    @Test
    fun `load image use case failure test`() = runTest {
        coEvery { imageRepository.fetchImages() } returns Result.failure(mockk())

        val result = loadImageUseCase()

        coVerify { imageRepository.fetchImages() }

        assertTrue(result.isFailure)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}