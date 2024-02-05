package uz.salikhdev.movedb.core.model.login


import com.google.gson.annotations.SerializedName

data class TokenResonse(
    @SerializedName("expires_at")
    val expiresAt: String, // 2024-02-02 12:39:18 UTC
    @SerializedName("request_token")
    val requestToken: String, // a1b54353c96d285d462f3f34a2e63f3bbd0c011b
    @SerializedName("success")
    val success: Boolean // true
)