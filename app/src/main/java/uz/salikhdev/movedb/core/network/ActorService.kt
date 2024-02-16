package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.actor.actor_detail.ActorDetailResponse
import uz.salikhdev.movedb.core.model.actor.actor_image.ActorImageResponse

interface ActorService {

    @GET("/3/person/{person_id}/images")
    suspend fun getActorImages(
        @Path("person_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActorImageResponse?>

    @GET("/3/person/{person_id}")
    suspend fun getActorDetail(
        @Path("person_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActorDetailResponse?>

}