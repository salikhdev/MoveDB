package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.actor.ActorResponse
import uz.salikhdev.movedb.core.model.detail.DetailResponse

interface DetailService {

    @GET("/3/movie/{movie_id}")

    suspend fun getDetail(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<DetailResponse?>


    @GET("3/movie/{movie_id}/credits")
    suspend fun getActors(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActorResponse?>


}