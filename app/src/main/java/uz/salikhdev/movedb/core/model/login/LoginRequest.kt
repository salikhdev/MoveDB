package uz.salikhdev.movedb.core.model.login


import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    val password: String, // qwert1234
    @SerializedName("request_token")
    val requestToken: String, // df35a7746db79d47a55648035ce7339ff6defaf4
    @SerializedName("username")
    val username: String // Muhammadsolih_Abdugafforov
)