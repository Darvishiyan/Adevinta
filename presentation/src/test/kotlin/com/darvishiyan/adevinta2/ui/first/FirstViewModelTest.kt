package com.darvishiyan.adevinta2.ui.first

import com.darvishiyan.adevinta2.ui.first.state.FirstPageState
import com.darvishiyan.domain.interactor.LoadImageUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FirstViewModelTest {

    @MockK
    lateinit var loadImageUseCase: LoadImageUseCase

    private lateinit var viewModel: FirstViewModel

    private val coroutineDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(coroutineDispatcher)
        MockKAnnotations.init(this)
    }

    @Test
    fun `first view model Noting state`() = runTest {
        viewModel = FirstViewModel(loadImageUseCase)

        val result = viewModel.fetchState.first()

        assertTrue(result is FirstPageState.Noting)
    }

    @Test
    fun `first view model Success state`() = coroutineDispatcher.runBlockingTest {
        coEvery { loadImageUseCase() } returns Result.success(listOf())

        viewModel = FirstViewModel(loadImageUseCase)

        viewModel.fetchImages()

        val result = viewModel.fetchState.first()

        coVerify { loadImageUseCase() }
        assertTrue(result is FirstPageState.Success)
    }

    @Test
    fun `first view model Error state`() = coroutineDispatcher.runBlockingTest {
        coEvery { loadImageUseCase() } returns Result.failure(mockk())

        viewModel = FirstViewModel(loadImageUseCase)

        viewModel.fetchImages()

        val result = viewModel.fetchState.first()

        coVerify { loadImageUseCase() }
        assertTrue(result is FirstPageState.Error)
    }

    @After
    fun tearDown() {
        unmockkAll()
        Dispatchers.resetMain()
    }

}