package com.danigutiadan.mo2o_test.api

import com.danigutiadan.mo2o_test.features.beer.search.data.BeerResponse
import com.danigutiadan.mo2o_test.features.beer.search.data.BeerResponseApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {


    @GET("beers")
    suspend fun getBeersByName(
        @Query("beer_name") name: String? = null
    ): Response<List<BeerResponseApi>>


}