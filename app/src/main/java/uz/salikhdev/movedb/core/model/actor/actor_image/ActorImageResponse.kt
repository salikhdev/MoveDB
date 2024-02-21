package uz.salikhdev.movedb.core.model.actor.actor_image


import com.google.gson.annotations.SerializedName
import uz.salikhdev.movedb.core.model.home.BaseData

data class ActorImageResponse(
    @SerializedName("id")
    val id: Int, // 819
    @SerializedName("profiles")
    val profiles: List<Profile>
) : BaseData() {
    override fun getType(): Int {
        return ACTOR
    }

}