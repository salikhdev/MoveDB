package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse

interface HomeService {

    @GET("/3/movie/now_playing")
    suspend fun nowPlaying(
        @Query("api_key") apiKey: String
    ): Response<NowPlayingResponse?>


    @GET("/3/movie/popular")
    suspend fun popular(
        @Query("api_key") apiKey: String
    ): Response<PopularResponse?>

}