package com.sylvainmrzd.bankinchallenge.feature_categories_list.data

import com.sylvainmrzd.bankinchallenge.feature_categories_list.domain.model.ResourcesItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("categories.json")
    suspend fun getResourcesItems(): ResourcesItem

    companion object {
        private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        private val client = OkHttpClient.Builder().addInterceptor(logging).build()

        private var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/bankin-engineering/challenge-android/master/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}