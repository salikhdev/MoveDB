package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.BuildConfig
import uz.salikhdev.movedb.core.model.acting.acting.ActingResponse
import uz.salikhdev.movedb.core.network.ActingService
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class ActingRepository @Inject constructor(private val service: ActingService) {

    suspend fun getActing(id: Int): ResultWrapper<ActingResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getActingFilms(id, BuildConfig.API_KEY)
        }
    }

}