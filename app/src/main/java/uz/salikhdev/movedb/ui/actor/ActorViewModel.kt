package uz.salikhdev.movedb.ui.actor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.model.acting.acting.ActingResponse
import uz.salikhdev.movedb.core.model.actor.actor_detail.ActorDetailResponse
import uz.salikhdev.movedb.core.model.actor.actor_image.ActorImageResponse
import uz.salikhdev.movedb.core.repository.ActingRepository
import uz.salikhdev.movedb.core.repository.ActorRepository
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class ActorViewModel @Inject constructor(
    private val repository: ActorRepository,
    private val repo: ActingRepository
) : ViewModel() {

    val imagesLD: MutableLiveData<ActorImageResponse?> = MutableLiveData()
    val detailLD: MutableLiveData<ActorDetailResponse?> = MutableLiveData()
    val errorLD: MutableLiveData<String> = MutableLiveData()
    val actingLD: MutableLiveData<ActingResponse?> = MutableLiveData()
    val actingError: MutableLiveData<String> = MutableLiveData()

    fun getActingFilms(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repo.getActing(id)) {
                is ResultWrapper.ErrorResponse -> {
                    actingError.postValue(result.error.toString())
                }

                is ResultWrapper.NetworkError -> {
                    actingError.postValue("NETWORK_ERROR")
                }

                is ResultWrapper.Success -> {
                    actingLD.postValue(result.response)
                }
            }
        }
    }

    fun getActorImages(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {

            when (val result = repository.getActorImages(id)) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.postValue(result.error.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.postValue("NETWORK_ERROR")
                }

                is ResultWrapper.Success -> {
                    imagesLD.postValue(result.response)
                }
            }


        }

    }
    fun getActorDetail(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {

            when (val result = repository.getActorDetail(id)) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.postValue(result.error.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.postValue("NETWORK_ERROR")
                }

                is ResultWrapper.Success -> {
                    detailLD.postValue(result.response)
                }
            }


        }


    }

}