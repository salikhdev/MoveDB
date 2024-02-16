package uz.salikhdev.movedb.core.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String?,
    val rating: Int?,
    val language: String?,
    val genre: List<Int>?,
    val publishedTime: String?,
    val budget: Int?,
    val status: String?,
    val overview: String?,
    val image: String?
) : Serializable
