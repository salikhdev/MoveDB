package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.BuildConfig
import uz.salikhdev.movedb.core.model.actor.actor_detail.ActorDetailResponse
import uz.salikhdev.movedb.core.model.actor.actor_image.ActorImageResponse
import uz.salikhdev.movedb.core.network.ActorService
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class ActorRepository @Inject constructor(private val service: ActorService) {

    suspend fun getActorImages(id: Int): ResultWrapper<ActorImageResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getActorImages(id, BuildConfig.API_KEY)
        }
    }

    suspend fun getActorDetail(id: Int): ResultWrapper<ActorDetailResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getActorDetail(id, BuildConfig.API_KEY)
        }
    }

}