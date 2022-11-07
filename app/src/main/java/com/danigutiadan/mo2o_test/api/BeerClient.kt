package com.danigutiadan.mo2o_test.api

import javax.inject.Inject

class BeerClient @Inject constructor(private val webService: WebService) {

    suspend fun fetchBeer(
        page: Int
    ): ApiResponse<PokemonResponse> =
        webService.fetchPokemonList(
            limit = PAGING_SIZE,
            offset = page * PAGING_SIZE
        )
}