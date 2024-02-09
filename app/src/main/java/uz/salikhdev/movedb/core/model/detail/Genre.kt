package uz.salikhdev.movedb.core.model.detail


import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id")
    val id: Int, // 18
    @SerializedName("name")
    val name: String // Drama
)