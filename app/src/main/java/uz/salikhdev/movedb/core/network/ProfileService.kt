package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.login.MessageResponse
import uz.salikhdev.movedb.core.model.login.SessionRequest
import uz.salikhdev.movedb.core.model.profile.ProfileDetailResponse

interface ProfileService {

    @GET("/3/account")
    suspend fun loadAccountDetail(
        @Query("api_key") apiKey: String,
        @Query("session_id") sessionId: String
    ): Response<ProfileDetailResponse?>

    @HTTP(method = "DELETE", path = "/3/authentication/session", hasBody = true)
    suspend fun logOut(
        @Query("api_key") apiKey: String,
        @Body body: SessionRequest
    ): Response<MessageResponse?>

}