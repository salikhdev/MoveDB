package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.acting.acting.ActingResponse

interface ActingService {

    @GET("/3/person/{person_id}/movie_credits")
    suspend fun getActingFilms(
        @Path("person_id") id: Int,
        @Query("api_key") apiKey: String
    ): Response<ActingResponse?>


}