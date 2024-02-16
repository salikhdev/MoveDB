package uz.salikhdev.movedb.core.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String?,
    val rating: Double?,
    val genre: Int?,
    val publishedTime: String?,
    val image: String?
) : Serializable
