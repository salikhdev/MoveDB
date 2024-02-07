package uz.salikhdev.movedb.core.model.home.now_play


import com.google.gson.annotations.SerializedName
import uz.salikhdev.movedb.core.model.home.BaseData

data class NowPlayingResponse(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val nowPlayResults: List<NowPlayResult>,
    @SerializedName("total_pages")
    val totalPages: Int, // 153
    @SerializedName("total_results")
    val totalResults: Int // 3047
) : BaseData() {
    override fun getType(): Int {
        return NOW_PLAYING
    }

}