package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.home.HomePageResponse

interface HomeService {

    @GET("/3/movie/now_playing")
    suspend fun nowPlaying(
        @Query("api_key") apiKey: String
    ): Response<HomePageResponse?>

}