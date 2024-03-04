package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.BuildConfig
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse
import uz.salikhdev.movedb.core.network.SeeMoreService
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class SeeMoreRepository @Inject constructor(private val service: SeeMoreService) {

    suspend fun getNowPlaying(page: Int): ResultWrapper<NowPlayingResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.nowPlaying(BuildConfig.API_KEY, 15, page)
        }
    }

    suspend fun getPopular(page: Int): ResultWrapper<PopularResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.popular(BuildConfig.API_KEY, 15, page)
        }
    }
}