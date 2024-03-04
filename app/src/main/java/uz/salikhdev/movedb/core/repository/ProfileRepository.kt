package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.BuildConfig
import uz.salikhdev.movedb.core.model.login.MessageResponse
import uz.salikhdev.movedb.core.model.login.SessionRequest
import uz.salikhdev.movedb.core.model.profile.ProfileDetailResponse
import uz.salikhdev.movedb.core.network.ProfileService
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val service: ProfileService
) {

    suspend fun getProfileDetails(sessionId: String): ResultWrapper<ProfileDetailResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.loadAccountDetail(BuildConfig.API_KEY, sessionId)
        }
    }

    suspend fun logOut(session: SessionRequest): ResultWrapper<MessageResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.logOut(BuildConfig.API_KEY, session)
        }
    }


}