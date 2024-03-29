package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.BuildConfig
import uz.salikhdev.movedb.core.model.login.LoginRequest
import uz.salikhdev.movedb.core.model.login.SessionResponse
import uz.salikhdev.movedb.core.model.login.TokenRequest
import uz.salikhdev.movedb.core.model.login.TokenResonse
import uz.salikhdev.movedb.core.network.AuthService
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(private val service: AuthService) {

    suspend fun getToken(): ResultWrapper<TokenResonse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getNewToken(BuildConfig.API_KEY)
        }
    }

    suspend fun getNewSession(body: TokenRequest): ResultWrapper<SessionResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.createNewSession(BuildConfig.API_KEY, body)
        }
    }

    suspend fun login(body: LoginRequest): ResultWrapper<LoginRequest?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.login(BuildConfig.API_KEY, body)
        }
    }

}