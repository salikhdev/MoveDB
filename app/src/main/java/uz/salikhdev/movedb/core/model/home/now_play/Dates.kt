package uz.salikhdev.movedb.core.model.home.now_play


import com.google.gson.annotations.SerializedName

data class Dates(
    @SerializedName("maximum")
    val maximum: String, // 2024-02-14
    @SerializedName("minimum")
    val minimum: String // 2024-01-03
)