package com.darvishiyan.data.datasource

import com.darvishiyan.data.remote.ApiService
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
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RemoteDataSourceImlTest {

    @MockK
    lateinit var apiService: ApiService

    @InjectMockKs
    lateinit var remoteDataSource: RemoteDataSourceIml

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `remote data source fetch image test`() = runTest {
        coEvery { apiService.fetchImage() } returns mockk()

        remoteDataSource.fetchImage()

        coVerify { apiService.fetchImage() }
    }

    @After
    fun tearDown() {
        unmockkAll()
    }
}