package uz.salikhdev.movedb.core.model.actor.actor_image


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double, // 0.667
    @SerializedName("file_path")
    val filePath: String, // /5XBzD5WuTyVQZeS4VI25z2moMeY.jpg
    @SerializedName("height")
    val height: Int, // 771
    @SerializedName("iso_639_1")
    val iso6391: Any, // null
    @SerializedName("vote_average")
    val voteAverage: Double, // 5.346
    @SerializedName("vote_count")
    val voteCount: Int, // 17
    @SerializedName("width")
    val width: Int // 514
)