package uz.salikhdev.movedb.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse
import uz.salikhdev.movedb.core.repository.HomeRepository
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val homeNowPlayingLiveData: MutableLiveData<NowPlayingResponse?> = MutableLiveData()
    val homePopularLiveData: MutableLiveData<PopularResponse?> = MutableLiveData()
    val homeError: MutableLiveData<String?> = MutableLiveData()

    fun getHomeNowPlaying() {
        viewModelScope.launch {
            when (val response = repository.getNowPlaying()) {
                is ResultWrapper.ErrorResponse -> {
                    homeError.value = response.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    homeError.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    homeNowPlayingLiveData.value = response.response
                }
            }

        }
    }

    fun getHomePopular() {
        viewModelScope.launch {

            when (val response = repository.getPopular()) {
                is ResultWrapper.ErrorResponse -> {
                    homeError.value = response.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    homeError.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    homePopularLiveData.value = response.response
                }
            }

        }
    }


}