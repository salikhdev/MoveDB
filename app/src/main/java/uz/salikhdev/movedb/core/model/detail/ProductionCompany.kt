package uz.salikhdev.movedb.core.model.detail


import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    val id: Int, // 508
    @SerializedName("logo_path")
    val logoPath: String, // /7cxRWzi4LsVm4Utfpr1hfARNurT.png
    @SerializedName("name")
    val name: String, // Regency Enterprises
    @SerializedName("origin_country")
    val originCountry: String // US
)