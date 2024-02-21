package uz.salikhdev.movedb.core.model.acting.acting


import com.google.gson.annotations.SerializedName
import uz.salikhdev.movedb.core.model.home.BaseData

data class ActingResponse(
    @SerializedName("cast")
    val cast: List<Any>,
    @SerializedName("crew")
    val crew: List<Crew>,
    @SerializedName("id")
    val id: Int
) : BaseData() {
    override fun getType(): Int {
        return ACTING
    }

}