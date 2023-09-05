package com.darvishiyan.adevinta2.ui.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.darvishiyan.adevinta2.ui.first.state.FirstPageState
import com.darvishiyan.domain.interactor.LoadImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val loadImage: LoadImageUseCase
) : ViewModel() {
    private val _fetchState = MutableStateFlow<FirstPageState>(FirstPageState.Noting)
    val fetchState: StateFlow<FirstPageState> = _fetchState

    fun fetchImages() {
        viewModelScope.launch {
            _fetchState.emit(FirstPageState.Noting)
            loadImage().let {
                when {
                    it.isSuccess -> _fetchState.emit(FirstPageState.Success(it.getOrNull()))
                    it.isFailure -> _fetchState.emit(FirstPageState.Error(it.exceptionOrNull()))
                }
            }
        }
    }

}
