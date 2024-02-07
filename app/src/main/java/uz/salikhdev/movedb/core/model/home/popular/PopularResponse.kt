package uz.salikhdev.movedb.core.model.home.popular


import com.google.gson.annotations.SerializedName
import uz.salikhdev.movedb.core.model.home.BaseData

data class PopularResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val popularResults: List<PopularResult>,
    @SerializedName("total_pages")
    val totalPages: Int, // 42661
    @SerializedName("total_results")
    val totalResults: Int // 853212
) : BaseData() {
    override fun getType(): Int {
        return POPULAR
    }

}