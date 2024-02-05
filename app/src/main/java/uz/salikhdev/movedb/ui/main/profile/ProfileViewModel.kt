package uz.salikhdev.movedb.ui.main.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.cache.AppCache
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

}