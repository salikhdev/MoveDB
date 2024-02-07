package uz.salikhdev.movedb.core.repository

import kotlinx.coroutines.Dispatchers
import uz.salikhdev.movedb.core.model.home.HomePageResponse
import uz.salikhdev.movedb.core.network.HomeService
import uz.salikhdev.movedb.core.util.ResultWrapper
import uz.salikhdev.movedb.core.util.parseResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeService: HomeService) {

    suspend fun getHomeService(api: String): ResultWrapper<HomePageResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            homeService.nowPlaying(api)
        }
    }


}