package com.danigutiadan.mo2o_test.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {


    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<BeerResponse>


}