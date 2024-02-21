package uz.salikhdev.movedb.ui.main.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.cache.AppCache
import uz.salikhdev.movedb.core.model.login.MessageResponse
import uz.salikhdev.movedb.core.model.login.SessionRequest
import uz.salikhdev.movedb.core.model.profile.ProfileDetailResponse
import uz.salikhdev.movedb.core.repository.ProfileRepository
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val response: ProfileRepository,
    private val cache: AppCache
) : ViewModel() {

    val profileDetailLD: MutableLiveData<ProfileDetailResponse?> = MutableLiveData()
    val logOutLD: MutableLiveData<MessageResponse?> = MutableLiveData()
    val errorLD: MutableLiveData<String> = MutableLiveData()


    fun getProfileDetail() {

        val sessionId = cache.getSessionId()

        viewModelScope.launch {

            val result = response.getProfileDetails(sessionId)
            Log.d("TAGaaaa", "getProfileDetail: ")

            when (result) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = result.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    profileDetailLD.value = result.response
                }
            }

        }

    }

    fun logOut() {

        val sessionid = cache.getSessionId()

        viewModelScope.launch(Dispatchers.IO) {

            val session = SessionRequest(sessionid)

            when (val result = response.logOut(session)) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.postValue(result.code.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.postValue("NETWORK_ERROR")
                }

                is ResultWrapper.Success -> {
                    logOutLD.postValue(result.response)
                }
            }

        }

    }

    fun isFirstAndCleaCache() {
        cache.isFirst(true)
        cache.removeSession()
    }

}