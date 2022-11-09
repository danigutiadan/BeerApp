package com.danigutiadan.mo2o_test.features.beer.search.data

import com.danigutiadan.mo2o_test.data.resultLiveData
import javax.inject.Inject

class BeersRepository @Inject constructor(private val remoteSource: BeersRemoteDataSource) {

    fun getBeersByName(name: String? = null) = resultLiveData(networkCall = {
        remoteSource.getBeerByName(name)
    })
}