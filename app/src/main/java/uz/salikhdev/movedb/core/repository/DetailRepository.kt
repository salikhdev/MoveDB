package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.core.model.actor.ActorResponse
import uz.salikhdev.movedb.core.model.detail.DetailResponse
import uz.salikhdev.movedb.core.network.DetailService
import uz.salikhdev.movedb.core.util.API_KEY
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class DetailRepository @Inject constructor(private val service: DetailService) {
    suspend fun getDetailData(movieId: Int): ResultWrapper<DetailResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getDetail(movieId, API_KEY)
        }
    }

    suspend fun getActorData(movieId: Int): ResultWrapper<ActorResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getActors(movieId, API_KEY)
        }
    }

}