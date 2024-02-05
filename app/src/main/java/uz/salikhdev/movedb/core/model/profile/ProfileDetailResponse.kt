package uz.salikhdev.movedb.core.model.profile


import com.google.gson.annotations.SerializedName

data class ProfileDetailResponse(
    @SerializedName("avatar")
    val avatar: Avatar,
    @SerializedName("id")
    val id: Int, // 20957804
    @SerializedName("include_adult")
    val includeAdult: Boolean, // false
    @SerializedName("iso_3166_1")
    val iso31661: String, // US
    @SerializedName("iso_639_1")
    val iso6391: String, // en
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String // Muhammadsolih_Abdugafforov
)