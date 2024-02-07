package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.core.model.home.now_play.NowPlayingResponse
import uz.salikhdev.movedb.core.model.home.popular.PopularResponse
import uz.salikhdev.movedb.core.network.HomeService
import uz.salikhdev.movedb.core.util.API_KEY
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeService: HomeService) {

    suspend fun getNowPlaying(): ResultWrapper<NowPlayingResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            homeService.nowPlaying(API_KEY)
        }
    }

    suspend fun getPopular(): ResultWrapper<PopularResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            homeService.popular(API_KEY)
        }
    }

}