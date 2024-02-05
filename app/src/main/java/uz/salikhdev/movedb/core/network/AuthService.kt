package uz.salikhdev.movedb.core.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import uz.salikhdev.movedb.core.model.login.LoginRequest
import uz.salikhdev.movedb.core.model.login.SessionResponse
import uz.salikhdev.movedb.core.model.login.TokenRequest
import uz.salikhdev.movedb.core.model.login.TokenResonse

interface AuthService {


    @GET("/3/authentication/token/new")
    suspend fun getNewToken(@Query("api_key") apiKey: String): Response<TokenResonse?>

    @POST("/3/authentication/session/new")
    suspend fun createNewSession(
        @Query("api_key") apiKey: String,
        @Body request: TokenRequest
    ): Response<SessionResponse?>

    @POST("/3/authentication/token/validate_with_login")
    suspend fun login(
        @Query("api_key") apiKey: String,
        @Body body: LoginRequest
    ): Response<LoginRequest?>


}