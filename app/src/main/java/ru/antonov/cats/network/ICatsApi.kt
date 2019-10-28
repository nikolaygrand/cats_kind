package ru.antonov.cats.network

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap
import ru.antonov.cats.data.CatsBreads

interface ICatsApi {
    @GET("breeds")
    fun getCatBreeds(@Query("attach_breed") attachBreed: Int = 0,
                     @QueryMap options: Map<String, String> = mapOf()): Observable<Response<ResponseBody>>
}