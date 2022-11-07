package com.danigutiadan.mo2o_test.api

import java.io.Serializable

abstract class BaseModel : Serializable {
    abstract fun toApi(): BaseApi?
}

abstract class BaseApi : Serializable {
    abstract fun toModel(): BaseModel?
}

data class ListSuccess(val listElements: List<BaseModel>) : BaseModel() {
    override fun toApi(): ListSuccesApi {
        val listElementsApi = mutableListOf<BaseApi>()
        listElements.forEach { it.toApi()?.apply { listElementsApi.add(this) } }
        return ListSuccesApi(listElementsApi)
    }
}

data class ListSuccesApi(val listElements: List<BaseApi>) : BaseApi() {
    override fun toModel(): ListSuccess {
        val listElementsModel = mutableListOf<BaseModel>()
        listElements.forEach { it.toModel()?.apply { listElementsModel.add(this) } }
        return ListSuccess(listElementsModel)
    }
}

data class EmptySuccess(val success: Boolean = true) : BaseModel() {
    override fun toApi() = EmptySuccessApi(success)
}

data class EmptySuccessApi(val success: Boolean = true) : BaseApi() {
    override fun toModel() = EmptySuccess(success)
}