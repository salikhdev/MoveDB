package uz.salikhdev.movedb.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.model.home.HomePageResponse
import uz.salikhdev.movedb.core.repository.HomeRepository
import uz.salikhdev.movedb.core.util.API_KEY
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val homeLiveData: MutableLiveData<HomePageResponse?> = MutableLiveData()
    val homeError: MutableLiveData<String?> = MutableLiveData()

    fun getHomeInfo() {
        val apikey = API_KEY
        viewModelScope.launch {

            when (val response = repository.getHomeService(apikey)) {
                is ResultWrapper.ErrorResponse -> {
                    homeError.value = response.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    homeError.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    homeLiveData.value = response.response
                }
            }

        }
    }


}