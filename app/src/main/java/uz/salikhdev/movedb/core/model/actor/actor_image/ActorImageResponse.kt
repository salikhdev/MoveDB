package uz.salikhdev.movedb.core.model.actor.actor_image


import com.google.gson.annotations.SerializedName

data class ActorImageResponse(
    @SerializedName("id")
    val id: Int, // 819
    @SerializedName("profiles")
    val profiles: List<Profile>
)