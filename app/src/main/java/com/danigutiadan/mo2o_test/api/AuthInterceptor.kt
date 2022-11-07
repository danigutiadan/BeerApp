package com.danigutiadan.mo2o_test.api

import android.content.Context
import com.danigutiadan.mo2o_test.R
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*

class AuthInterceptor: Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .build()
        return chain.proceed(request)
    }


}