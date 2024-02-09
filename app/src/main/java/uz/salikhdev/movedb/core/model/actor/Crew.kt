package uz.salikhdev.movedb.core.model.actor


import com.google.gson.annotations.SerializedName

data class Crew(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("credit_id")
    val creditId: String, // 621353ffdfe31d006e38861b
    @SerializedName("department")
    val department: String, // Production
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("id")
    val id: Int, // 976
    @SerializedName("job")
    val job: String, // Producer
    @SerializedName("known_for_department")
    val knownForDepartment: String, // Acting
    @SerializedName("name")
    val name: String, // Jason Statham
    @SerializedName("original_name")
    val originalName: String, // Jason Statham
    @SerializedName("popularity")
    val popularity: Double, // 169.622
    @SerializedName("profile_path")
    val profilePath: String // /lldeQ91GwIVff43JBrpdbAAeYWj.jpg
)