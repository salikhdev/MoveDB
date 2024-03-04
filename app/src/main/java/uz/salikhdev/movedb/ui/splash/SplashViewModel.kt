package uz.salikhdev.movedb.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.salikhdev.movedb.core.cache.AppCache
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val cache: AppCache) : ViewModel() {


    val isFirsLD: MutableLiveData<Boolean> = MutableLiveData()

    fun getIsFirs() {
        isFirsLD.value = cache.isFirst
    }


}