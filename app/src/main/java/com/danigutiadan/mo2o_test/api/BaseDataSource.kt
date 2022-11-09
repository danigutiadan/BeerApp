package com.danigutiadan.mo2o_test.api

import com.danigutiadan.mo2o_test.data.Error.TimeoutError
import com.danigutiadan.mo2o_test.data.Error.UnknownHostError
import com.danigutiadan.mo2o_test.data.Result
import retrofit2.Response
import timber.log.Timber
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * Abstract Base Data source class with error handling
 */
abstract class BaseDataSource {

    private val standardError = "Network call has failed"


    protected suspend fun <T> getResultCall(call: suspend () -> Response<T>): Result<BaseModel> {
        return try {
            val response = call()
            if (response.isSuccessful) {
                when (val responseBody = response.body()) {
                    is BaseApi -> {
                        Result.success(responseBody.toModel()!!)
                    }
                    is List<*> -> {
                        when {
                            responseBody.isEmpty() -> {
                                Result.success(EmptySuccess())
                            }
                            responseBody.find { it !is BaseApi } == null -> {
                                val responseModel = mutableListOf<BaseModel>()
                                responseBody.forEach {
                                    (it as BaseApi).toModel()?.apply { responseModel.add(this) }
                                }
                                Result.success(ListSuccess(responseModel))
                            }
                            else -> {
                                Result.error(response.message(), code = response.code())
                            }
                        }
                    }
                    null -> {
                        Result.success(EmptySuccess())
                    }
                    else -> {
                        Result.error(response.message(), code = response.code())
                    }
                }
            } else {
                Result.error(response.errorBody()?.toString() ?: "", code = response.code())
            }
        } catch (exc: Exception) {
            manageApiException(exc)
        }
    }

    private fun <T> manageApiException(exc: Exception): Result<T> {
        when (exc) {
            is TimeoutException -> {
                return Result.error(exc.localizedMessage ?: exc.message ?: "", code = TimeoutError)
            }
            is SocketTimeoutException -> {
                return Result.error(exc.localizedMessage ?: exc.message ?: "", code = TimeoutError)
            }
            is UnknownHostException -> {
                return Result.error(
                    exc.localizedMessage ?: exc.message
                    ?: "", code = UnknownHostError
                )
            }
        }
        return error(exc.message ?: exc.toString())
    }

    private fun <T> error(message: String): Result<T> {
        Timber.e(message)
        return Result.error("$standardError for a following reason: $message")
    }

}

