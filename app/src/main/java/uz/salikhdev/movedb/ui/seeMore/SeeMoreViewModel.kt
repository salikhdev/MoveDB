package uz.salikhdev.movedb.ui.seeMore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse
import uz.salikhdev.movedb.core.repository.SeeMoreRepository
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class SeeMoreViewModel @Inject constructor(private val repository: SeeMoreRepository) :
    ViewModel() {

    val nowPlayingLD: MutableLiveData<NowPlayingResponse?> = MutableLiveData()
    private var page = 1
    val errorLD: MutableLiveData<String?> = MutableLiveData()
    val popularLD: MutableLiveData<PopularResponse?> = MutableLiveData()

    fun getNowPlaying() {
        viewModelScope.launch {
            when (val response = repository.getNowPlaying(page)) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = response.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    nowPlayingLD.postValue(response.response)
                    page++
                }
            }

        }
    }

    fun getPopular() {
        viewModelScope.launch {
            when (val response = repository.getPopular(page)) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = response.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    popularLD.value = response.response
                    page++
                }
            }

        }
    }


}