package uz.salikhdev.movedb.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.model.actor.ActorResponse
import uz.salikhdev.movedb.core.model.detail.DetailResponse
import uz.salikhdev.movedb.core.repository.DetailRepository
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val response: DetailRepository,
) : ViewModel() {

    val detailLD: MutableLiveData<DetailResponse?> = MutableLiveData()
    val actorLD: MutableLiveData<ActorResponse?> = MutableLiveData()
    val errorLD: MutableLiveData<String> = MutableLiveData()


    fun getDetail(id: Int) {

        viewModelScope.launch {

            val result = response.getDetailData(id)

            when (result) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = result.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    result.response?.let {
                        detailLD.value = it
                    }
                }
            }

        }

    }

    fun getActor(id: Int) {

        viewModelScope.launch {

            val result = response.getActorData(id)

            when (result) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = result.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    result.response?.let {
                        actorLD.value = it
                    }
                }
            }

        }

    }


}