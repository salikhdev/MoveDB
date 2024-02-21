package uz.salikhdev.movedb.core.model.trailers


import com.google.gson.annotations.SerializedName

data class TrailersResponse(
    @SerializedName("id")
    val id: Int, // 550
    @SerializedName("results")
    val trailersResults: List<TrailersResult>
)