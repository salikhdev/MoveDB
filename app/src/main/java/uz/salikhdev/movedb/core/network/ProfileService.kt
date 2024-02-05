package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.profile.ProfileDetailResponse

interface ProfileService {

    @GET("/3/account")
    suspend fun loadAccountDetail(
        @Query("api_key") apiKey: String,
        @Query("session_id") sessionId: String
    ): Response<ProfileDetailResponse?>

}