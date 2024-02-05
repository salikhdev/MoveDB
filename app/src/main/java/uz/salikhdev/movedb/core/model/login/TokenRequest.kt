package uz.salikhdev.movedb.core.model.login


import com.google.gson.annotations.SerializedName

data class TokenRequest(
    @SerializedName("request_token")
    val requestToken: String // f5c00f466299bfba78718581ab07f19fec1f85e6
)