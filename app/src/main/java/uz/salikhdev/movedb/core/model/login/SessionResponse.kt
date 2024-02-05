package uz.salikhdev.movedb.core.model.login


import com.google.gson.annotations.SerializedName

data class SessionResponse(
    @SerializedName("session_id")
    val sessionId: String, // 350bac92df8de19ee45d6fc4f164044e083dd9d5
    @SerializedName("success")
    val success: Boolean // true
)