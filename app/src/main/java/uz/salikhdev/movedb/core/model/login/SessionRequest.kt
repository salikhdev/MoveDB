package uz.salikhdev.movedb.core.model.login


import com.google.gson.annotations.SerializedName

data class SessionRequest(
    @SerializedName("session_id")
    val sessionId: String // 2629f70fb498edc263a0adb99118ac41f0053e8c
)