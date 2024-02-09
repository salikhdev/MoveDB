package uz.salikhdev.movedb.core.model.actor


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("cast_id")
    val castId: Int, // 1
    @SerializedName("character")
    val character: String, // Adam Clay
    @SerializedName("credit_id")
    val creditId: String, // 6129889455c92600639df293
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("id")
    val id: Int, // 976
    @SerializedName("known_for_department")
    val knownForDepartment: String, // Acting
    @SerializedName("name")
    val name: String, // Jason Statham
    @SerializedName("order")
    val order: Int, // 0
    @SerializedName("original_name")
    val originalName: String, // Jason Statham
    @SerializedName("popularity")
    val popularity: Double, // 169.622
    @SerializedName("profile_path")
    val profilePath: String // /lldeQ91GwIVff43JBrpdbAAeYWj.jpg
)