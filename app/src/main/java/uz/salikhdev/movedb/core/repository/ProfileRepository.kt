package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.core.model.profile.ProfileDetailResponse
import uz.salikhdev.movedb.core.network.ProfileService
import uz.salikhdev.movedb.core.util.API_KEY
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val service: ProfileService) {

    suspend fun getProfileDetails(sessionId: String): ResultWrapper<ProfileDetailResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.loadAccountDetail(API_KEY, sessionId)
        }
    }

}