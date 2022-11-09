package com.danigutiadan.mo2o_test.features.beer.search.data

import com.danigutiadan.mo2o_test.api.BaseDataSource
import com.danigutiadan.mo2o_test.api.WebService
import javax.inject.Inject

class BeersRemoteDataSource @Inject constructor(private val service: WebService) :
    BaseDataSource() {

    suspend fun getBeerByName(name: String? = null) = getResultCall { service.getBeersByName(name) }
}