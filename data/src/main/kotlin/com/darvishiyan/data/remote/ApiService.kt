package com.darvishiyan.data.remote

import com.darvishiyan.entity.remote.ServerResponseModel
import retrofit2.http.GET

interface ApiService {

    @GET("374286327/")
    suspend fun fetchImage(): ServerResponseModel

}
