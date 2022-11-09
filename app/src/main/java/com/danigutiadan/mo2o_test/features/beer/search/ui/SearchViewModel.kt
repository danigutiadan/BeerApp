package com.danigutiadan.mo2o_test.features.beer.search.ui

import androidx.lifecycle.LiveData
import com.danigutiadan.mo2o_test.api.BaseModel
import com.danigutiadan.mo2o_test.features.beer.search.data.BeersRepository
import com.danigutiadan.mo2o_test.ui.BaseViewModel
import com.danigutiadan.mo2o_test.ui.ViewModelValidation
import com.danigutiadan.mo2o_test.ui.resettableLazy
import com.danigutiadan.mo2o_test.data.Result
import javax.inject.Inject

class SearchViewModel @Inject constructor(private val beersRepository: BeersRepository) :
    BaseViewModel() {
    var beerName: String? = null

    val beers: LiveData<Result<BaseModel>> by resettableLazy(lazyMgr) {
        beersRepository.getBeersByName(beerName)
    }

    override fun isValid() = ViewModelValidation(true)
}