package uz.salikhdev.movedb.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.cache.AppCache
import uz.salikhdev.movedb.core.model.login.LoginRequest
import uz.salikhdev.movedb.core.model.login.SessionResponse
import uz.salikhdev.movedb.core.model.login.TokenRequest
import uz.salikhdev.movedb.core.repository.AuthRepository
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository,
    private val cache: AppCache
) : ViewModel() {

    val tokenLD: MutableLiveData<String> = MutableLiveData()
    val errorLD: MutableLiveData<String> = MutableLiveData()
    val loginLD: MutableLiveData<LoginRequest> = MutableLiveData()
    val sessionLD: MutableLiveData<SessionResponse> = MutableLiveData()

    fun getToken() {
        viewModelScope.launch {
            val result = repository.getToken()

            when (result) {
                is ResultWrapper.Success -> {
                    tokenLD.value = result.response?.requestToken
                }

                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = "Token yaralmadi"
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }
            }

        }
    }

    fun getSession(request: TokenRequest) {


        viewModelScope.launch {

            val result = repository.getNewSession(request)

            when (result) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = result.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    result.response?.let {
                        sessionLD.value = it
                    }
                }
            }


        }


    }

    fun login(body: LoginRequest) {
        viewModelScope.launch {
            val result = repository.login(body)

            when (result) {
                is ResultWrapper.Success -> {
                    result.response?.let {
                        loginLD.value = it
                    }
                }

                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = result.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }
            }

        }
    }

    fun saveSessionIdToStorage(session: String) {
        cache.saveSession(session)
    }

}