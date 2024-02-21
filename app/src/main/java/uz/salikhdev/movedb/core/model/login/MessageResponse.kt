package uz.salikhdev.movedb.core.model.login


import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("success")
    val success: Boolean // true
)