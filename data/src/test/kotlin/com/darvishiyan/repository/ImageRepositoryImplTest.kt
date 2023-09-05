package com.darvishiyan.repository

import com.darvishiyan.data.datasource.RemoteDataSource
import com.darvishiyan.domain.repository.ImageRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ImageRepositoryImplTest {

    @MockK
    lateinit var remoteDataSource: RemoteDataSource

    private lateinit var imageRepository: ImageRepository

    private val coroutineDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        imageRepository = ImageRepositoryImpl(remoteDataSource, coroutineDispatcher)
    }

    @Test
    fun `image repository fetch image test`() = runTest(coroutineDispatcher) {
        coEvery { remoteDataSource.fetchImage() } returns mockk()

        imageRepository.fetchImages()

        coVerify { remoteDataSource.fetchImage() }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}