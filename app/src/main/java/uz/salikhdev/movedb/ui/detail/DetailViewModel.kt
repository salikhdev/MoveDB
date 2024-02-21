package uz.salikhdev.movedb.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.model.actor.actor_list.ActorResponse
import uz.salikhdev.movedb.core.model.detail.DetailResponse
import uz.salikhdev.movedb.core.model.trailers.TrailersResponse
import uz.salikhdev.movedb.core.repository.DetailRepository
import uz.salikhdev.movedb.core.room.database.MovieDataBase
import uz.salikhdev.movedb.core.room.entity.MovieEntity
import uz.salikhdev.movedb.core.util.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val response: DetailRepository,
    private val dataBase: MovieDataBase
) : ViewModel() {

    val detailLD: MutableLiveData<DetailResponse?> = MutableLiveData()
    val trailsLD: MutableLiveData<TrailersResponse?> = MutableLiveData()
    val actorLD: MutableLiveData<ActorResponse?> = MutableLiveData()
    val errorLD: MutableLiveData<String> = MutableLiveData()
    val haveDataInDB: MutableLiveData<Boolean> = MutableLiveData()

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
    fun saveData(movie: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.moviesDao().saveMovie(movie)
            haveDataInDB.postValue(true)
        }
    }
    fun deleteData(movie: MovieEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dataBase.moviesDao().deleteMovie(movie)
            haveDataInDB.postValue(false)
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
    fun isSave(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val ids = dataBase.moviesDao().getID()
            if (ids.contains(id)) {
                haveDataInDB.postValue(true)
            } else {
                haveDataInDB.postValue(false)
            }
        }
    }

    fun getTrails(id: Int) {

        viewModelScope.launch {

            when (val result = response.getTrailersData(id)) {
                is ResultWrapper.ErrorResponse -> {
                    errorLD.value = result.code.toString()
                }

                is ResultWrapper.NetworkError -> {
                    errorLD.value = "NETWORK_ERROR"
                }

                is ResultWrapper.Success -> {
                    result.response?.let {
                        trailsLD.value = it
                    }
                }
            }

        }

    }


}