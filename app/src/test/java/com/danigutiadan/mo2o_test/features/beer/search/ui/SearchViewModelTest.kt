package com.danigutiadan.mo2o_test.features.beer.search.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danigutiadan.mo2o_test.api.ListSuccess
import com.danigutiadan.mo2o_test.data.Result
import com.danigutiadan.mo2o_test.features.beer.search.data.BeersRepository
import getOrAwaitValueTest
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @RelaxedMockK
    lateinit var beersRepository: BeersRepository

    lateinit var searchViewModel: SearchViewModel



    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        searchViewModel = SearchViewModel(beersRepository)
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun checkViewModelDataIsSameAsRepository() = runBlocking {
        val result = Result(Result.Status.SUCCESS, ListSuccess(emptyList()), "", 200)

        coEvery { beersRepository.getBeersByName(any()) } returns MutableLiveData(result)
        //When

        val response = searchViewModel.beers

        //Then

        assert(result == response.getOrAwaitValueTest())

    }

}