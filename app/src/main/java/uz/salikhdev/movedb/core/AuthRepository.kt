package uz.salikhdev.movedb.core

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.core.model.login.LoginRequest
import uz.salikhdev.movedb.core.model.token.TokenResonse
import uz.salikhdev.movedb.core.network.AuthService
import uz.salikhdev.movedb.core.util.API_KEY
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(private val service: AuthService) {


    suspend fun getToken(): ResultWrapper<TokenResonse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getNewToken(API_KEY)
        }
    }

    suspend fun login(body: LoginRequest): ResultWrapper<LoginRequest?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.login(API_KEY, body)
        }
    }

}