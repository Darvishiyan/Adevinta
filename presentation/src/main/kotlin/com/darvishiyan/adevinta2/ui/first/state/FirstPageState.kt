package com.darvishiyan.adevinta2.ui.first.state

import com.darvishiyan.entity.remote.MotorImage

sealed class FirstPageState {
    data object Noting : FirstPageState()
    data class Success(val value: List<MotorImage>?) : FirstPageState()
    data class Error(val error: Throwable?) : FirstPageState()
}
