package uz.salikhdev.movedb.core.model.trailers


import com.google.gson.annotations.SerializedName

data class TrailersResult(
    @SerializedName("id")
    val id: String, // 639d5326be6d88007f170f44
    @SerializedName("iso_3166_1")
    val iso31661: String, // US
    @SerializedName("iso_639_1")
    val iso6391: String, // en
    @SerializedName("key")
    val key: String, // O-b2VfmmbyA
    @SerializedName("name")
    val name: String, // Fight Club (1999) Trailer - Starring Brad Pitt, Edward Norton, Helena Bonham Carter
    @SerializedName("official")
    val official: Boolean, // false
    @SerializedName("published_at")
    val publishedAt: String, // 2016-03-05T02:03:14.000Z
    @SerializedName("site")
    val site: String, // YouTube
    @SerializedName("size")
    val size: Int, // 720
    @SerializedName("type")
    val type: String // Trailer
)