package uz.salikhdev.movedb.ui.main.save

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.salikhdev.movedb.core.room.database.MovieDataBase
import uz.salikhdev.movedb.core.room.entity.MovieEntity
import javax.inject.Inject

@HiltViewModel
class SaveViewModel @Inject constructor(private val dataBase: MovieDataBase) : ViewModel() {

    val saveLD: MutableLiveData<List<MovieEntity>> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = dataBase.moviesDao().getMovie()
            saveLD.postValue(data)
        }
    }


}